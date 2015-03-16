// Using sort and then recurrsion to resolve ordering requirements
// Use one variable instead of copying arrays to save space usage

public class Solution {
        public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

	        if(candidates == null || candidates.length == 0 || target <= 0)
	            return new ArrayList<ArrayList<Integer>>();
	        Arrays.sort(candidates);
	        return solve(candidates, target, candidates.length);
	        
	   }

	    public ArrayList<ArrayList<Integer>> solve(int[] candidates, int target, int size) {
	        if(0 == size){
	            if(target != 0)
	                return null;
	            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	            res.add(new ArrayList<Integer>());
	            return res;
	        }

	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        int val = candidates[size-1];
	        for(int i = 0; i*val <= target; ++i) {
	            int subTarget = target - val*i;
	            ArrayList<ArrayList<Integer>> sub = solve(candidates,subTarget,size-1);
	            if(sub == null)
	                continue;
	            for(ArrayList<Integer> s: sub){
	                for(int k = 1; k<=i; ++k)
	                    s.add(val);
	            }
	            res.addAll(sub);
	        }
	        return res;
	    }         


}
