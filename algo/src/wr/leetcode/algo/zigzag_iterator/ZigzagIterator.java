package wr.leetcode.algo.zigzag_iterator;


import java.util.*;

public class ZigzagIterator {

    //always keep alive iterators
    //BUG: initialized!!
    ArrayList<Iterator<Integer>> iterators = new ArrayList<>();
    int index = 0;


    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        ArrayList<List<Integer>> vectors = new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);

        for (List<Integer> vector : vectors) {
            Iterator<Integer> ite = vector.iterator();
            if(ite.hasNext()) {
                iterators.add(ite);
            }
        }
    }

    public int next() {

        if(!hasNext()) {
            throw new IllegalArgumentException("No next!");
        }
        Iterator<Integer> ite = iterators.get(index);
        int ret = ite.next();

        if( !ite.hasNext() ) {
            iterators.remove(index);
            // no increment when iterator removed
        } else {
            index ++;
        }

        if(index == iterators.size()) {
            index = 0;
        }
        return ret;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList( Integer.valueOf(1), Integer.valueOf(2));
        List<Integer> v2 = Arrays.asList( Integer.valueOf(3),
                Integer.valueOf(4),
                Integer.valueOf(5),
                Integer.valueOf(6));

        ZigzagIterator iterator = new ZigzagIterator(v1,v2);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */