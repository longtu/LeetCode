public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.isEmpty())
            return res;
        genIPAddress(s, 0, 0, res, "");
        return res;
    }

    private void genIPAddress(String s, int step, int index, ArrayList<String> res, String base)    {
        if(step == 4){
            //index exceeds or not enough
            if(index != s.length())
                return;
            res.add( base);
            return;
        }
        //generte base
        String subBase = base;
        if(step != 0)
            subBase += ".";
        for(int i = 1; i<=3; ++i){
            //each step cannot start with '0'
            if(i > 1 && s.charAt(index) == '0')
                return;

            if(index+i > s.length())
                return;
            Integer val = Integer.parseInt(s.substring(index, i+index));
            if(val > 255)
                return;
            genIPAddress(s,step+1,index+i, res, subBase+val);
        }
    }
}

/////////Second Implementation


import java.util.ArrayList;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        genIP(0, 0, s, "", res);
        return res;
    }

    private boolean isValidSub(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.length() == 2)
            return (s.compareTo("99") <= 0) && (s.compareTo("10") >= 0);
        if (s.length() == 3)
            return (s.compareTo("255") <= 0) && (s.compareTo("100") >= 0);
        return false;
    }

    private void genIP(int index, int stage, String s, String curr,
            ArrayList<String> res) {
        if (stage == 3) {
            String sub = s.substring(index);
            if (isValidSub(sub))
                res.add(curr + sub);
            return;
        }
        for (int i = 1; i <= 3 && index + i < s.length(); ++i) {
            String sub = s.substring(index, index + i);
            if (isValidSub(sub))
                genIP(index + i, stage + 1, s, curr + sub + ".", res);
        }
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses("25525511135"));
        System.out.println("TEST");

    }

}
