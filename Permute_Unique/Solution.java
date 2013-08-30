public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(num == null || num.length == 0 )
            return res; 

        if(num.length == 1){
            ArrayList<Integer> re = new ArrayList<Integer>();
            re.add(num[0]);
            res.add(re);
            return res;
        }

        int [] sub = new int[num.length-1];
        System.arraycopy(num,0,sub,0,num.length-1);
        ArrayList<ArrayList<Integer>> all = permuteUnique(sub);
        for(ArrayList<Integer> al : all){
            for(int i = 0; i <= al.size(); ++i){
                ArrayList<Integer> re = new ArrayList<Integer>(al);
                re.add(i, num[num.length-1]);
                res.add(re); 
                if(i < al.size() && al.get(i) == num[num.length-1])
                    break;
            }
        }
        return res;
    }
}

