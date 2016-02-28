package wr.leetcode.algo.Linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllTriangles {
    public List<List<Integer>> validTriangle(int[] edges) {
        List<List<Integer>> result = new ArrayList<>();
        if (edges == null || edges.length < 3) {
            return result;
        }

        Arrays.sort(edges);

        for (int i = 0; i < edges.length - 2; i++) {
            for (int j = i + 1; j < edges.length - 1; j++) {
                for (int k = j + 1; k < edges.length; k++) {
                    if (edges[i] + edges[j] > edges[k]) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(edges[i]);
                        curr.add(edges[j]);
                        curr.add(edges[k]);
                        result.add(curr);
                    }
                }
            }
        }

        return result;
    }
}
