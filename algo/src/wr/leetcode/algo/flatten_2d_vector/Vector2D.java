package wr.leetcode.algo.flatten_2d_vector;

import java.util.*;

public class Vector2D {

    ListIterator<List<Integer>> listIte;
    Iterator<Integer> ite = new LinkedList<Integer>().iterator();


    public Vector2D(List<List<Integer>> vec2d) {
        listIte = vec2d.listIterator();
    }

    public int next() {
        if(hasNext()) {
            return ite.next();
        } else {
            throw new IllegalStateException("No more elements!");
        }
    }

    public boolean hasNext() {
        //BUG: cannot deal with double empty iterator in the front
        //if(!ite.hasNext() && listIte.hasNext()) {
        while(!ite.hasNext() && listIte.hasNext()) {
            ite = listIte.next().iterator();
        }
        return ite.hasNext();
    }

    public static void main(String[] args) {

        List<List<Integer>> sol = new LinkedList<>();
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new LinkedList<>();
        b.add(3);
        List<Integer> c = new LinkedList<>();
        c.add(4);
        c.add(5);
        c.add(6);
        sol.add(a);
        sol.add(b);
        sol.add(c);

        Vector2D vector2D = new Vector2D(sol);

        while(vector2D.hasNext()) {
            System.out.println(vector2D.next());
        }
    }


}