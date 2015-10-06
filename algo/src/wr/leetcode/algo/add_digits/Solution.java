package wr.leetcode.algo.add_digits;

public class Solution {
    public int addDigits(int val) {
        /*int num = val;
        while (num >= 10) {
            String digits = Integer.toString(num);
            num = 0;
            for (char ch : digits.toCharArray()) {
                num += ch -'0';
            }
        }
        return num;
        */

        return (val > 9) ? ((val-10)%9 + 1) : (val);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addDigits(38));
    }
}
