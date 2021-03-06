package wr.leetcode.algo.Linkedin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnionOfTwoSortedList {
    public static Iterable<Integer> intersection(Iterator<Integer> a,
                                                 Iterator<Integer> b) {
        List<Integer> result = new ArrayList<>();

        Integer currA = null;
        Integer currB = null;

        if (a.hasNext()) {
            currA = a.next();
        }

        if (b.hasNext()) {
            currB = b.next();
        }


        while (currA != null && currB != null) {
            if (currA.equals(currB)) {
                result.add(currA);

                if (a.hasNext()) {
                    currA = a.next();
                } else {
                    currA = null;
                }

                if (b.hasNext()) {
                    currB = b.next();
                } else {
                    currB = null;
                }
            } else if (currA < currB) {
                result.add(currA);

                if (a.hasNext()) {
                    currA = a.next();
                } else {
                    currA = null;
                }
            } else {
                result.add(currB);

                if (b.hasNext()) {
                    currB = b.next();
                } else {
                    currB = null;
                }
            }
        }
        while (currA != null) {
            result.add(currA);
            if (a.hasNext()) {
                currA = a.next();
            } else {
                currA = null;
            }
        }

        while (currB != null) {
            result.add(currB);
            if (b.hasNext()) {
                currB = b.next();
            } else {
                currB = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(5);
        b.add(6);

        Iterable<Integer> result = intersection(a.iterator(), b.iterator());

        for (Integer num : result) {
            System.out.println(num);
        }
    }
}
