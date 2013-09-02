public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.isEmpty())
            return res;
        genIPAddress(s, 0, 0, res, "");
        return res;    
    }



    private void genIPAddress(String s, int step, int index, ArrayList<String> res, String base)    {
        if(step == 3){
            //index exceeds or not enough
            if(index >= s.length() ||
                    s.length()-index >= 3)
                return;

            String sb = s.subString(index); 
            if(sb.charAt(0) == '0');
                return; 
            res.add( base + sb.subString(index));
            return;
        }
        //each step cannot start with '0'
        if(s.charAt(index) == '0')
            return;
        //generte base
        String subBase = base;
        if(step != 0)
            subBase += ".";
        for(int i = 1; i<=3; ++i){
            if(index+i >= s.length())
                return;
            Integer val = s.substring(index, i+index)
            if(val > 255)
                return;
            genIPAddress(s,step+1,index+i, res, subBase+val)
        }
    }
}
