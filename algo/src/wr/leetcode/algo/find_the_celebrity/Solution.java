package wr.leetcode.algo.find_the_celebrity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution extends Relation{

    public int findCelebrity0(int n) {
        ArrayList<Integer> candidate = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            candidate.add(i);
        }

        while(candidate.size() > 1) {
            int len = candidate.size();
            int left = candidate.get(len-2);
            int right = candidate.get(len-1);
            if(knows(left, right)) {
                candidate.remove(len-2);
            } else {
                candidate.remove(len-1);
            }
        }

        int c = candidate.get(0);
        //BUG: verify in two direction of knows:
        for (int i = 0; i < n; ++i) {
            if( i != c && (knows(c, i) || !knows(i,c) )) {
                c =-1;
                break;
            }
        }
        return c;
    }

    public int findCelebrity(int n) {
        List<Integer> candidates = new LinkedList<>();
        for ( int i = 0; i < n; ++i) {
            candidates.add(i);
        }

        while(candidates.size() > 1) {
            int l = candidates.get(0);
            int r = candidates.get(1);
            if(knows(l,r)) {
                candidates.remove(0);
            } else {
                candidates.remove(1);
            }
        }

        int c = candidates.get(0);
        return (isCelebrity(c, n))?(c):(-1);

    }

    public boolean isCelebrity( int c, int n) {
        boolean ret = true;
        for (int i = 0; i < n; ++i) {
            if (c != i && (!knows(i,c) || knows(c, i)) ) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}

class Relation {
    public boolean knows(int a, int b){
        return true;
    }
}
