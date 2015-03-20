package wr.leetcode.algo.compare_version_numbers;

public class Tester {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.compareVersion("1.0", "1"));
        System.out.println(sol.compareVersion("1.0.0.0.0.1", "1.0"));
        System.out.println(sol.compareVersion("1.2", "13.37"));
    }
}
