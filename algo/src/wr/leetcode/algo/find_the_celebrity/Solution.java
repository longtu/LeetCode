package wr.leetcode.algo.find_the_celebrity;

import java.util.ArrayList;

public class Solution extends Relation{

    public int findCelebrity(int n) {
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
}

class Relation {
    public boolean knows(int a, int b){
        return true;
    }
}
