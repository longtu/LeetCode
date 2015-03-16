public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0 || target <=0)
			return res;
		Arrays.sort(num);
		int[][] dp = new int[num.length+1][target+1]; 
		//by java spec, array is initialized with 0 for integer
		for(int i = 0; i <= num.length; ++i){
			dp[i] = new int[target+1];
		}
		dp[0][0] = 1;
		for(int i = 1; i <= num.length; ++i)
			for(int j =1; j <= target; ++j){
                //this needs to be taken care of
				if(i >1 && num[i-1] == num[i-2]){
					if((j-num[i-1] >= 0) && (dp[i-1][j-num[i-1]]==1)){
						dp[i][j] = 1;
					}
					continue;
				}
				for(int k = i-1; k>=0; --k){
					if((j-num[i-1] >= 0) && (dp[k][j-num[i-1]]==1)){
						dp[i][j] = 1;
					}
				}
			}
		for(int j = num.length; j>=1; --j)
			if(dp[j][target] == 1)
				res.addAll(getPath(dp, target, j, num));
		return res;
	}

	private ArrayList<ArrayList<Integer>> getPath(int [][]dp, int target,
			int index, int [] num){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(index == 0){
			res.add(new ArrayList<Integer>());
			return res;
		}

		for(int i= index-1; i>=0; i--){
			if((target-num[index-1]) >= 0 && dp[i][target-num[index-1]] == 1){
                //this needs to be taken care of
				if(index > 1 && num[index-1] == num[index-2] && i < index-1){
					break;
				}
				ArrayList<ArrayList<Integer>> all = getPath(dp, target-num[index-1],
						i, num);				
				for(ArrayList<Integer> al:all){
					ArrayList<Integer> r = new ArrayList<Integer>(al);
					r.add(num[index-1]);
					res.add(r);
				}
			}
		}
		return res;
	}
}
