public class Solution {
    public String countAndSay(int n) {
        String curr = new String("1");
        for(int i = 1; i<n; ++i){
            StringBuilder sb = new StringBuilder();
            char [] prev = curr.toCharArray();
            char last = 255;
            int count = 0;
            for (char val: prev){
                if(last == 255){
                    count ++;
                    last = val;
                }
                else if(val == last){
                    count ++;
                }else {
                    sb.append(count);
                    sb.append(last);
                    count = 1;
                    last = val;
                }
            }
            sb.append(count);
            sb.append(last);
            curr = sb.toString();
        }
        return curr;
    }
}
