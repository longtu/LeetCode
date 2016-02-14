package wr.leetcode.algo.palindrome_permutation;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(null == s) {
            return true;
        }
        int[] count = new int[256];
        for (char ch : s.toCharArray()) {
            count[ ch ] += 1;
        }
        int odds = 0;
        for (int i = 0; i < 256; ++i) {
            if(1 == count[i]%2) {
                odds++;
            }
        }
        return odds < 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (String str : new String[] {
            "code","aab","carerac","",null
        }) {
            System.out.println(sol.canPermutePalindrome(str));
        }
    }
}
