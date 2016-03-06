package wr.leetcode.algo.Facebook;

public class MutateInputArray {
    public static void mutate(int[] A, int[] pos) {
        if( null == A || null == pos) {
            return;
        }

        for (int i = 0; i < A.length; ++i) {
            while (pos[i] != i) {
                int j = pos[i];
                swap(i,j,pos);
                swap(i,j,A);
            }
        }

    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {

        int[] A = new int[]{5, 6, 7, 8, 9};
        int[] pos = new int[]{4, 3, 2, 1, 0};

        MutateInputArray.mutate(A, pos);

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println("");
    }
}
