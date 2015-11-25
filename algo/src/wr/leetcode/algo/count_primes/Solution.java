package wr.leetcode.algo.count_primes;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int countPrimes(int n) {
        int ret = 0;
        boolean [] prime = new boolean [n];
        Arrays.fill(prime, true);

        for (int i = 2; i * i < n; ++i ) {
            if(!prime[i]) {
                continue;
            }
            for (int j = i; j*i < n; ++j) {
                //BUG: should not check if(prime[j]) {
                int key = i * j;
                prime[key] = false;
            }
        }

        for (int i = 2; i < n; ++i) {
            if(prime[i]) {
                System.out.println(i);
                ret ++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countPrimes(1000));
    }


    public int countPrimes0(int n) {

        boolean [] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i*i < n; ++i) {
            if(!primes[i]) {
                continue;
            }
            for (int j = 2; j <= i; ++ j) {
                if(!primes[j]) {
                    continue;
                }
                int index = j * i;
                if( index < n) {
                    primes[index] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; ++i) {
            if(primes[i]) {
                count ++;
            }
        }
        return count;
    }

    /*
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
    /*

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
    */
}
