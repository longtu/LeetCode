package wr.leetcode.algo.Facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class SlidingWindowMaximum {
    //NLog(W) BST solution
    public static int[] maxSlidingWindow( int[] input, int w) {
        int n = input.length;
        int m = n - w + 1;
        if( m <=0) {
            throw new IllegalArgumentException("Input parameters not valid");
        }
        int [] ret = new int[m];

        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            int key = input[i];
            int cnt = tree.getOrDefault(key, 0) + 1;
            tree.put(key, cnt);
            if(i >= w-1) {
                ret[i-w+1] = tree.lastKey();
                int r = input[i-w+1];
                int d = tree.get(r) - 1;
                if (d == 0) {
                    tree.remove(r);
                } else {
                    tree.put(r, d);
                }
            }
        }
        return ret;
    }

    //O(N) Linear solution
    //O(N) Linear solution
    public static int[] maxSlidingWindowV2( int[] input, int w) {
        int n = input.length;
        int m = n - w + 1;
        if( m <=0) {
            throw new IllegalArgumentException("Input parameters not valid");
        }
        int [] ret = new int[m];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int v = input[i];
            list.add(v);
            //BUG: did you really test it !!!
            while(list.size() > 1 && (list.get(0) < v)) {
                list.remove(0);
            }
            System.out.println(list);
            if(i >= w-1) {
                ret[i-w+1] = list.get(0);
                if(input[i-w+1] == list.get(0)) {
                    list.remove(0);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindowV2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

    }
}
