package wr.leetcode.algo.restore_ip_addresses;

import java.util.LinkedList;
import java.util.List;

public class Solution {



    public boolean isValidIP( String str ) {
        boolean ret = false;
        //BUG: has to check str emptiness or size, otherwise parseInt will fail
        if(!str.isEmpty() && str.length() < 4) {
            Integer val = Integer.parseInt(str);
            ret = (val.toString().equals(str) && val >= 0 && val <= 255);
        }
        return ret;
    }

    public List<String> restoreIpRec(String s, int k ) {
        List<String> ret = new LinkedList<>();
        if( 0 == k ) {
            if(isValidIP(s)) {
                ret.add(s);
            }
        } else {
            for ( int e = 1; e <=3 && e <= s.length() ; e++) {
                String str = s.substring(0, e);
                if(isValidIP(str)) {
                    List<String> subs = restoreIpRec(s.substring(e), k-1);
                    for (String sub : subs) {
                        ret.add(str + "." + sub);
                    }
                }
            }
        }
        return ret;
    }



    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<>();
        if( null != s && s.length() > 3) {
            ret = restoreIpRec(s, 3);
        }
        return ret;
    }




    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses("25525511135"));
        System.out.println(sol.restoreIpAddresses("0000"));
        System.out.println(sol.restoreIpAddresses("010010"));

    }



    /*
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList();
        if(null == s || s.length() < 4) {
            return ret;
        }
        List<Integer> partitions = new LinkedList();
        return restoreIpAddresses(s, partitions);
    }

    public List<String> restoreIpAddresses(String s, List<Integer> partitions) {
        List<String> ret = new LinkedList();
        if(4 == partitions.size()) {
            if(s.length() == partitions.get(3)) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i <=3; ++i){
                    sb.append((i>0)?("."):(""));
                    sb.append(s.substring(
                        (i>0)?(partitions.get(i-1)):(0),
                        partitions.get(i)));
                }
                ret.add(sb.toString());
            }
            return ret;
        }
        int pSize = partitions.size();
        int start = (pSize > 0)?(partitions.get(pSize-1)):(0);
        for (int end = start +1; end < start+4 && end <= s.length(); end++) {
            if(isValidIP(s.substring(start, end))){
                partitions.add(pSize, end);
                ret.addAll(restoreIpAddresses(s, partitions));
                partitions.remove(pSize);
            }
        }
        return ret;
    }

    public boolean isValidIP(String ip) {

        if(ip.startsWith("0")){
            return ip.equals("0");
        }
        try{
            Integer val = Integer.parseInt(ip);
            return  (val >=0 && val <= 255);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
