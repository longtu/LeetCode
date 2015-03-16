public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0)
            return 0;
        int [] diff = new int [gas.length];
        int sum = 0;
        for(int i = 0; i < gas.length; ++i){
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if(sum < 0)
            return -1;
        return findMaxSum(diff);
    }

    int findMaxSum(int [] diff){
        int start = 0;
        int end = start;
        int sum = diff[0];
        int step = 1;

        while(step < diff.length){
            if(sum < 0){
                while(sum < 0){
                    start = (start+1)%diff.length;
                    if(step == 1){
                        end = start;
                        sum = diff[start];
                    }
                    else {
                        sum -= diff[start];
                        step--;
                    }
                }
            }
            end = (end+1)%diff.length;
            sum += diff[end];
            step += 1;
        }
        return start;
    
    }
}

