package wr.leetcode.algo.Linkedin;

import java.util.List;

public class NetedIntegerSum {
    public int depthSum (List<NestedInteger> input) {
        return depthSum(input, 1);
    }

    public int depthSum( List<NestedInteger> input, int level ) {
        int sum = 0;
        for (NestedInteger data : input) {
            int val;
            if (data.isInteger()) {
                val = data.getInteger() * level;
            } else {
                val = depthSum(data.getList(), level + 1);
            }
            sum += val;
        }
        return sum;
    }

    /**
     * Followup: What if the list is in reverse order?
     * e.g. {{1, 1}, 2, {1, 1}}, then 4 1s at depth 1, and one 2 at depth 2, so the sum is 8
     */

    public int depth(List<NestedInteger> input, int base) {
        int ret = 0;
        if ( null == input) {
            return 0;
        }
        for (NestedInteger data : input) {
            if (!data.isInteger()) {
                ret = Math.max(ret, depth(data.getList(), base+1));
            } else {
                ret = Math.max(ret, base);
            }
        }
        return ret;
    }

    public int depthSumRev (List<NestedInteger> input) {
        int level = depth(input, 0);
        return depthSumRev(input, level);
    }

    public int depthSumRev( List<NestedInteger> input, int level ) {
        int sum = 0;
        for (NestedInteger data : input) {
            int val;
            if (data.isInteger()) {
                val = data.getInteger() * level;
            } else {
                val = depthSumRev(data.getList(), level - 1);
            }
            sum += val;
        }
        return sum;
    }
}



interface NestedInteger {
    // Returns true if this NestedInteger holds
    // a single integer, rather than a nested list
    public boolean isInteger();

    // Returns the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Returns null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Returns the nested list that this NestedInteger
    // holds, if it holds a nested list
    // Returns null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}