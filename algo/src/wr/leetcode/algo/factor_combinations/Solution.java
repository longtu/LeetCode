package wr.leetcode.algo.factor_combinations;

import java.util.*;

public class Solution {

    //Method1: recursive, TLE Solution
    public List<List<Integer>> getFactors0(int n) {
        Map<Integer, Set<List<Integer>>> dp = new HashMap<>(n);
        for (int i = 4; i <= n; ++i) {
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

    //Method2:
    public List<List<Integer>> getFactors(int n) {

        int[] primes = primes(n/2);
        int m = primes.length;
        Map<Integer, Integer> factors = new LinkedHashMap<>();
        for (int i = 0; i < m; ++i) {
            int prime = primes[i];
            int factor = prime;
            int count = 0;
            while(factor < n && 0 == (n % factor)) {
                count += 1;
                factor *= prime;
            }
            if( count > 0 ) {
                factors.put(prime, count);
            }
        }
        return null;

    }

    public Set<List<Integer>> factors (LinkedHashMap<Integer, Integer> factors) {
        Set<List<Integer>> ret = new HashSet<>();
        return ret;
    }


    //primes smaller or equal to n
    public int[] primes( int n) {
        List<Integer> ret = new LinkedList<>();
        return null;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i : new int[] {
                1,37,12,32, 62847
        }) {
            System.out.println(sol.getFactors(i));
        }

    }
}
