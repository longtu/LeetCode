package wr.leetcode.algo.Linkedin;

import java.util.*;

public class MergeKSortedIterators {
    public static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
        List<Integer> result = new ArrayList<>();
        if (iterators == null || iterators.size() == 0) {
            return result;
        }

        PriorityQueue<PeekIterator> pq = new PriorityQueue<>(iterators.size(),
            (a,b)->(a.peek()-b.peek())
        );

        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                pq.add(new PeekIterator(iterator));
            }
        }

        while (!pq.isEmpty()) {
            PeekIterator curr = pq.poll();
            result.add(curr.next());
            if (curr.hasNext()) {
                pq.add(curr);
            }
        }

        return result;
    }

    private static class PeekIterator implements Iterator<Integer> {
        Integer next = null;
        Iterator<Integer> iterator = null;

        public PeekIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            advance();
        }

        private void advance() {
            if( null != next ) {
                return;
            }
            if(iterator.hasNext()) {
                next = iterator.next();
            }
        }

        public boolean hasNext() {
            advance();
            return (null != next);
        }

        public Integer next() {
            if(!hasNext()) {
                throw new IllegalStateException("No more elements!");
            }
            int ret = next;
            next = null;
            advance();
            return ret;
        }

        public Integer peek() {
            return next;
        }
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);

        List<Integer> c = new ArrayList<>();
        c.add(3);
        c.add(5);
        c.add(7);

        List<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(a.iterator());
        iterators.add(b.iterator());
        iterators.add(c.iterator());

        Iterable<Integer> result = mergeKSortedIterators(iterators);

        for (Integer num : result) {
            System.out.println(num);
        }
    }
}
