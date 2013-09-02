public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        if(n <= 0)
            return new ArrayList<Integer>();

        ArrayList<Integer> prev = null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean flag = true;
        for(int i = 1; i<=n; ++i){
            if(n == 1){
                res.add(0);
                res.add(1);
                continue;
            }
            prev = res;
            res = new ArrayList<Integer>();
            for(int i = 0; i < prev.size(); ++i )
                res.add( (prev.get(i)<<1)+((flag)?(0):(1)));
            flag = !flag;
            for(int i = prev.size-1(); i >= 0; --i )
                res.add( (prev.get(i)<<1)+((flag)?(0):(1)));
            flag = !flag;
        }
        return res;
    }
}

