package wr.leetcode.algo.factor_combinations;

import java.util.*;

public class Solution {

    public List<List<Integer>> getFactors(int n) {
        //MLE: HashMap(n) -> HashMap()
        Map<Integer, Set<List<Integer>>> dp = new HashMap<>();
        for (int i = 4; i <= n; ++i) {
            //TLE: Skip the ones are not dividable
            if( 0 != n % i ) {
                continue;
            }
            Set<List<Integer>> factorCombinations = new HashSet<>();
            for( int j = 2; j * 2 <= i; ++j) {
                if( 0 == i%j) {
                    int k = i/j;
                    Set<List<Integer>> subCombos = dp.getOrDefault(k, new HashSet());
                    List<Integer> list = new ArrayList<>();
                    list.add(k);
                    subCombos.add(list);
                    for (List<Integer> sub : subCombos) {
                        List<Integer> subCopy = new ArrayList<>(sub);
                        int insert = 0;
                        while(  insert < subCopy.size()) {
                            if(subCopy.get(insert) > j) {
                                break;
                            } else {
                                insert++;
                            }
                        }
                        subCopy.add(insert, j);
                        factorCombinations.add(subCopy);
                    }
                }
            }
            if(!factorCombinations.isEmpty()) {
                dp.put(i, factorCombinations);
            }
        }
        Set<List<Integer>> ret = dp.getOrDefault(n, new HashSet());
        return new LinkedList<>(ret);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i : new int[] {
                /*1,37,12,32, */62847, 23848713
        }) {
            System.out.println(sol.getFactors(i));
        }

    }
}
