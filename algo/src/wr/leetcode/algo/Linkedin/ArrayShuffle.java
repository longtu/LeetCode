package wr.leetcode.algo.Linkedin;

import java.util.Random;

public class ArrayShuffle {

    public void shuffle(int[] array) {
        if( null == array || array.length == 0) {
            return;
        }
        Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            int rand = random.nextInt(i+1);
            int tmp = array[rand];
            array[rand] = array[i];
            array[i] = tmp;
        }
    }


}
