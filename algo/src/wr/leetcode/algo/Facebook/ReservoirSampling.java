package wr.leetcode.algo.Facebook;

import java.util.Iterator;
import java.util.Random;

public class ReservoirSampling {
    //k is positive
    int[] reserviorSample( Iterator<Integer> ite, int k) {
        int[] ret = new int[k];
        int count = 0;
        Random random = new Random();

        while(ite.hasNext()) {
            int v = ite.next();
            if(count < k) {
                ret[count] = v;
            } else {
                /**
                 * Returns a pseudorandom, uniformly distributed int value
                 * between 0 (inclusive) and the specified value (exclusive),
                 * drawn from this random number generator's sequence.
                 */
                int id = random.nextInt(count+1);
                if(id < k) {
                    ret[id] = v;
                }
            }
            count++;
        }
        return ret;
    }
}
