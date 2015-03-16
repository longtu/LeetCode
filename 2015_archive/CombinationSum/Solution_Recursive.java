public class Solution {
     public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null || num.length == 0 || target <= 0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> index =  solve(num, target, num.length);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> tmp : index){
            ArrayList<Integer> al = new ArrayList<Integer>();
            res.add(al);
            for(Integer key: tmp){
                al.add(num[key]);
            }
        }
        return res;
    }

    //either use ArrayList<ArrayList<Integer>> int the interface to avoid dirty flag problem
    //or use index as result to check last used index
    public ArrayList<ArrayList<Integer>> solve(int[] num, int target, int size) {
        if(0 == size){
            if(target != 0)
                return null;
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            res.add(new ArrayList<Integer>());
            return res;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int val = num[size-1];

        for(int i = 0; i<=1 && target-i*val >=0; ++i) {
            int subTarget = target - val*i;
            ArrayList<ArrayList<Integer>> sub = solve(num,subTarget,size-1);
            if(sub == null)
                continue;
            for(ArrayList<Integer> s: sub){
                ArrayList<Integer> al = new ArrayList<Integer>();
                //i == 1 !!! only when current element would be added will be important
                if(i == 1 && size > 1 && num[size-1] == num[size-2]){
                    if(!(s.size() > 0 && s.get(s.size()-1)== size-2))
                        continue;
                }
                al.addAll(s);
                for(int k = 1; k<=i; ++k)
                    al.add(size-1);
                //store index instead of value will help remove duplicates
                res.add(al);
            }
        }
        return res;
    }  

}
