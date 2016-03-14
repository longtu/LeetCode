package wr.leetcode.algo.Facebook;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IsOneOrZeroEdit {


    public boolean isDistanceZeroOrOne(Iterator<Character> a, Iterator<Character> b) {
        boolean aExtra = false,
                bExtra = false,
                replace = false,
                hasDiff = false;

        Character pre_a = null;
        Character pre_b = null;

        while (a.hasNext() && b.hasNext()) {
            Character cur_a = a.next();
            Character cur_b = b.next();

            if (!aExtra && !bExtra && !replace) {
                if (cur_a != cur_b) {
                    aExtra = bExtra = replace = hasDiff = true;
                }
            } else {
                if (aExtra && pre_b != cur_a) {
                    aExtra = false;
                }
                if (bExtra && pre_a != cur_b) {
                    bExtra = false;
                }
                if (replace && cur_a != cur_b) {
                    replace = false;
                }
                if (!aExtra && !bExtra && !replace) {
                    break;
                }
            }
            pre_a = cur_a;
            pre_b = cur_b;
        }

        boolean ret;
        if (a.hasNext()) {
            int cur_a = a.next();
            ret = (!hasDiff || ((aExtra && pre_b == cur_a)))&& !a.hasNext();
        } else if(b.hasNext()) {
            int cur_b = b.next();
            ret = (!hasDiff || (bExtra && pre_a == cur_b)) && !b.hasNext();
        } else {
            ret = !hasDiff || replace;
        }
        return ret;
    }

    public Iterator<Character> ite( String str) {
        char[] chars = str.toCharArray();
        List<Character> charList = new LinkedList<>();
        for( char ch : chars) {
            charList.add(ch);
        }
        return charList.iterator();
    }

    public boolean isOneEditDistance(String s, String t) {
        s = (null == s)?(""):(s);
        t = (null == t)?(""):(t);

        return isDistanceZeroOrOne(ite(s), ite(t));
    }

    public boolean isDistanceOne(Iterator<Character> a, Iterator<Character> b) {
        boolean aExtra = false,
                bExtra = false,
                replace = false,
                hasDiff = false;

        Character pre_a = null;
        Character pre_b = null;

        while (a.hasNext() && b.hasNext()) {
            Character cur_a = a.next();
            Character cur_b = b.next();
            if (!aExtra && !bExtra && !replace) {
                if (cur_a != cur_b) {
                    aExtra = bExtra = replace = hasDiff = true;
                }
            } else {
                if (aExtra && pre_b != cur_a) {
                    aExtra = false;
                }
                if (bExtra && pre_a != cur_b) {
                    bExtra = false;
                }
                if (replace && cur_a != cur_b) {
                    replace = false;
                }
                if (!aExtra && !bExtra && !replace) {
                    break;
                }
            }
            pre_a = cur_a;
            pre_b = cur_b;
        }

        boolean ret;
        if (a.hasNext()) {
            int cur_a = a.next();
            ret = ((aExtra && pre_b == cur_a) || (!hasDiff)) && !a.hasNext();
        } else if(b.hasNext()) {
            int cur_b = b.next();
            ret = ((bExtra && pre_a == cur_b) || (!hasDiff)) && !b.hasNext();
        } else {
            ret = replace;
        }
        return ret;
    }
}
