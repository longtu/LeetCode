package wr.leetcode.algo.Linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
        return canPlaceFlowers(new ArrayList<>(flowerbed), numberToPlace, 0);
    }

    public boolean canPlaceFlowers(ArrayList<Boolean> flowerbed, int remaining, int index) {
        int n = flowerbed.size();
        if (index == n) {
            return (remaining == 0);
        }

        boolean ret = false;
        if (remaining >= 0){
            if (flowerbed.get(index)) {
                ret = canPlaceFlowers(flowerbed, remaining-1, index+1);
            } else {
                ret = canPlaceFlowers(flowerbed, remaining, index+1);
                if (!ret && (index-1 <0 || !flowerbed.get(index-1)) && (
                        index+1 >=n || !flowerbed.get(index+1))) {
                    flowerbed.set(index, true);
                    ret = canPlaceFlowers(flowerbed, remaining-1, index+1);
                    flowerbed.set(index, false);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        CanPlaceFlowers sol = new CanPlaceFlowers();

        int[][] arr = {{1,0,0,0,0,0,1,0,0},
                        {1,0,0,1,0,0,1,0,0},
                        {0}};

        for (int[] ar : arr) {
            List<Boolean> flowerbed = Arrays.stream(ar).boxed()
                    .map((a)->(a == 1))
                    .collect(Collectors.toList());

            for (int tst : new int[]{
                    -1,0,1,2,3,4,5,6
            }) {
                System.out.println( sol.canPlaceFlowers(flowerbed, tst));
            }
            System.out.println("----");
        }
    }
}
