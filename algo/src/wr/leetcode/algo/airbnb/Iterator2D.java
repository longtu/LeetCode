package wr.leetcode.algo.airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterator2D {
    List<Iterator<Integer>> iteList = new LinkedList<>();
    Iterator<Iterator<Integer>> iteIterator = null;
    Iterator<Integer> currIte = new LinkedList<Integer>().iterator();

    public Iterator2D(List<List<Integer>> vec2d) {
        vec2d = (null == vec2d) ? (new LinkedList<>()) : (vec2d);
        for (List<Integer> vec : vec2d) {
            if (null != vec && !vec.isEmpty()) {
                iteList.add(vec.iterator());
            }
        }
        iteIterator = iteList.iterator();
        if (iteIterator.hasNext()) {
            currIte = iteIterator.next();
        }
    }

    public int next() {
        advance();
        if (!hasNext()) {
            throw new IllegalStateException("No more next!");
        }
        return currIte.next();
    }

    public void advance(){
        if (!currIte.hasNext() && iteIterator.hasNext()) {
            currIte = iteIterator.next();
        }
    }

    public void remove() {
        currIte.remove();
    }

    public boolean hasNext() {
        return currIte.hasNext() || iteIterator.hasNext();
    }

    public static void main(String[] args) {


        List<List<Integer>> array = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        array.add(row1);

        List<Integer> row3 = new ArrayList<>();
        array.add(row3);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        array.add(row2);

        Iterator2D sol = new Iterator2D(array);
        while (sol.hasNext()) {
            int result = sol.next();
            System.out.println(result);

            if (result == 3) {
                sol.remove();
            }
        }

        System.out.println();

        for (List<Integer> row : array) {
            for (Integer elem : row) {
                System.out.println(elem);
            }
        }
    }
}
