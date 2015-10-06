package wr.leetcode.algo.count_primes;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if(n <= 1) {
            return 0;
        }

        Boolean [] isPrime = new Boolean[n];
        Arrays.fill(isPrime,true);

        /**
         * 1) only from 2 to i*i <n E.G 2*5 V.S 5*2
         * 2) only need prime numbers 2*x instead of 4*x
         * 3) only need 2*5 3*5 instead of 5*2, 5*3....
         */

        for (int i = 2; i * i < n; ++i) {
            if(!isPrime[i]){
                continue;
            }
            for (int j = i; j * i < n; ++j ) {
                isPrime[j*i] = false;
            }
        }

        int count = 0;
        for (int i = 2; i <n; ++i) {
            if(isPrime[i]) {
                count += i;
            }
        }
        return count;
    }
}
