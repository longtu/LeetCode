package wr.leetcode.algo.Linkedin;

import java.util.HashSet;
import java.util.Set;

public class CanIWin {
    Boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean ret = false;
        if (maxChoosableInteger >= 0 ) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= maxChoosableInteger;++i) {
                set.add(i);
            }
            ret = canIWin(set, desiredTotal);
        }
        return ret;
    }

    Boolean canIWin(Set<Integer> options, int desiredTotal) {
        boolean ret = false;
        Set<Integer> next = new HashSet<>(options);
        for (Integer v : options){
            int left = desiredTotal - v ;
            if (left <= 0) {
                ret = true;
                break;
            } else {
                next.remove(v);
                if (!canIWin(next, left)) {
                    ret = true;
                    break;
                }
                next.add(v);
            }
        }
        return ret;
    }
}
