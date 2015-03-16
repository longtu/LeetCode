public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String,Integer> countMap = new HashMap<String, Integer>();
        ArrayList<String> res = new ArrayList<String>();
        for(String str: strs){
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            int val = 0;
            if(!countMap.containsKey(key)){
                val = 1;
            }else{
                val = countMap.get(key)+1;
            }
            countMap.put(key,val);
        }
        for(String str: strs){
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(countMap.get(key) > 1)
                res.add(str);
        }
        return res;
    }
}
