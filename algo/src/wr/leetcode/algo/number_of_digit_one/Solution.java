package wr.leetcode.algo.number_of_digit_one;

public class Solution {


    public long countDigitOne(long n, long index) {
        long sum = 0;
        sum += n/(index * 10) * index;
        long res = n%(index*10);

        if(res >= index*2) {
            sum += index;
        } else if (res >= index){
            sum += res -index +1;
        }
        return sum;
    }


    public int countDigitOne(int n) {
        long sum = 0;
        if ( n > 0 ){
            long index = 1;
            while(index <= n) {
                sum += countDigitOne(n, index);
                index *= 10;
            }
        }
        return (int)sum;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.countDigitOne(13));
        System.out.println(sol.countDigitOne(0));
        System.out.println(sol.countDigitOne(1));
        System.out.println(sol.countDigitOne(2));
        System.out.println(sol.countDigitOne(3));
        System.out.println(sol.countDigitOne(9));
        System.out.println(sol.countDigitOne(11));
        System.out.println(sol.countDigitOne(110));
        System.out.println(sol.countDigitOne(111));
        System.out.println(sol.countDigitOne(119));
        System.out.println(sol.countDigitOne(209));
        System.out.println(sol.countDigitOne(1410065408));

    }
}