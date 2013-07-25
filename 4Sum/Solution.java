public class Solution {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4)
            return res;

        Arrays.sort(num);
        Map<Integer, List<Set<Integer>>> countMap = new HashMap<Integer, List<Set<Integer>>>();
        int lastI = -1;
        for(int i = 0; i< num.length; i++) {
            if(lastI != -1 && num[lastI] == num[i] ){
                continue;
            }
            int lastJ = -1;
            for(int j = i+1; j < num.length; j++) {
                if(lastJ != -1 && num[lastJ] == num[j]){
                    continue;
                }
                int sum = num[i] + num[j];        
                Set<Integer> pair = new HashSet<Integer>();
                pair.add(i);
                pair.add(j);
                lastJ = j;
                lastI = i;
                List<Set<Integer>> pairList = null;
                if(countMap.containsKey(sum)){
                    pairList = countMap.get(sum);
                }
                else{
                    pairList = new LinkedList<Set<Integer>>();
                }
                pairList.add(pair);
                countMap.put(sum,pairList);
            }
        }
        for(Integer sum: countMap.keySet()){
            if(!countMap.containsKey(target - sum)){
                continue;
            }
            List<Set<Integer>> srcPairList = countMap.get(sum);
            List<Set<Integer>> destPairList = countMap.get(target-sum);
            for(Set<Integer> srcPair: srcPairList){
                for (Set<Integer> destPair: destPairList){
                    Set<Integer> quatro = new HashSet<Integer>(srcPair);
                    quatro.addAll(destPair);
                    if(srcPair.size() < 4) {
                        continue;
                    }
                    Integer[] thisArray = quatro.toArray(new Integer[quatro.size()]);
                    Arrays.sort(thisArray);
                    ArrayList<Integer> thisList = new ArrayList<Integer>();
                    for(Integer val: thisArray) {
                        thisList.add(val);
                    }
                    res.add(thisList);
                }
            }
        }
        return res;
    }
}

