public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3)
            return 0;
        Arrays.sort(num);
        

        int minDiff = Integer.MAX_VALUE:
        int ret = 0;
        for (int i = 0 ; i < num.length-1; ++i) {
            int sum = target - num[i];
            //this i+1 would make sure the triple in increasing order
            for(int start = i+1, int end = num.length-1;
                start < end; ) {
                int val = num[start] + num[end];
                if( val == sum) {
                    return target;
                }
                int absVal =(val > sum) ? (val-sum):(sum-val);
                if(absVal < minDiff) {
                    ret = val+num[i];
                    minDiff = absVal;
                }
                if( val < sum) {
                    ++start;      
                }
                else{
                    --end;
                }
            }
        }
        return ret;
    }
}
