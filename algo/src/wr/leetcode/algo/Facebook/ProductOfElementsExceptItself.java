package wr.leetcode.algo.Facebook;

public class ProductOfElementsExceptItself {

    //One pass
    int[] products(int[] arr) {
        int N = arr.length;
        int[] result = new int[N];
        int left = 1, right = 1;
        for (int i = 0; i < N; ++i) {
            result[i] *= left;
            result[N - 1 - i] *= right;
            left *= arr[i];
            right *= arr[N - 1 - i];
        }
        return result;
    }
}
