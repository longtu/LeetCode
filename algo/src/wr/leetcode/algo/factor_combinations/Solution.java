package wr.leetcode.algo.factor_combinations;

import java.util.*;

public class Solution {

    /*
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

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<>();

        for(int i = 2; i * i <= n; ++i) {
            if( n % i == 0) {
                //i <= k
                int k = n/i;
                ret.add(Arrays.asList(i, k));
                List<List<Integer>> subfactors = getFactors( k );
                for (List<Integer> sub : subfactors) {
                    if( sub.get(0) >= i ) {
                        List<Integer> factor = new LinkedList<>(sub);
                        factor.add(0, i);
                        ret.add(factor);
                    }
                }
            }
        }
        return ret;
    }*/

    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }

    public List<List<Integer>> getFactors(int n, int start) {
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = start; i * i <= n; ++i) {
            if( 0 != (n%i) ) {
                continue;
            } else {
                int k = n/i;
                List<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(k);
                ret.add(list);
                List<List<Integer>> factors = getFactors(k, i);
                for (List<Integer> f : factors) {
                    f.add(0, i);
                    ret.add(f);
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i : new int[] {
                1,37,12,32, 62847, 23848713
        }) {
            System.out.println(sol.getFactors(i));
        }

    }
}
