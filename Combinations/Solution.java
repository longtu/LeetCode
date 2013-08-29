public class Solution {
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> all = new  ArrayList<ArrayList<Integer>>();       
    if(k==0){
        ArrayList<Integer> al = new ArrayList<Integer>();
        all.add(al);
        return all;
    }
    for(int i=k;i<=n;i++){                
        for(ArrayList<Integer> al : combine(i-1,k-1)){
            al.add(i);
            all.add(al);
        } 
    }
    return all;       
}
}
