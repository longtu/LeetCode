public class Solution {

    private int permu(int k){
        int res = 1;
        while(k>1){
            res *=k;
            k--;
        }
        return res;
    }

    public String getPermutation(int n, int k) {
        if(k<0 || k>permu(n) || n<=0)
            return null;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            digits.add(i);
        }
        return getPermutation(digits, k);
    }

    public String getPermutation(ArrayList<Integer> digits, int k){
        if(digits.isEmpty())
    		return "";
       int perm = permu(digits.size()-1);
       //the trick to getting ceiling
       int index = (k-1)/perm+1;
       //forgot to keep the character before removing it from the digits
       //modifying the data while using it
       int c = digits.get(index-1);
       digits.remove(index-1);
       String prev = getPermutation(digits, k-perm*(index-1));
       return c+prev;
    }
}
