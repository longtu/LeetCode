package wr.leetcode.algo.restore_ip_addresses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses("25525511135"));
        System.out.println(sol.restoreIpAddresses("0000"));
        System.out.println(sol.restoreIpAddresses("010010"));

    }




}
