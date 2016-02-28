package wr.leetcode.algo.Linkedin;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PowersIterator {
    Set<Long> prev;
    Queue<Index> heap;

    public PowersIterator() {
        reset();
    }

    /* Returns the next integer a in the arithmetic sequence of integers where
    * a = m^n, m > 1 n > 1, and m and n are both integers
    * Thus, the first few outputs will be 4, 8, 9, 16, 25, 27, 32, 36, etc.
    */
    public Long next() {
        Index next = heap.poll();
        int r = next.base;
        int c = next.power;

        Index right = new Index(r, c+1);
        heap.offer(right);
        prev.add(right.value);

        if(c == 2) {
            int dr = r + 1;
            while(prev.contains((long)dr)) {
                dr++;
            }
            Index down = new Index(dr, 2);
            heap.offer(down);
            prev.add(down.value);
        }

        return next.value;
    }

    /* Resets the sequence to the beginning, such that the next call to next()
    * will return 4.
    */
    public void reset() {
        prev = new HashSet<>();
        heap = new PriorityQueue<>((a,b)->{
            long diff = a.value - b.value;
            return (diff == 0L)?(0):((diff > 0)?(1):(-1));
        }
        );
        Index first = new Index(2,2);
        heap.offer(first);
        prev.add(first.value);
    }

    class Index {
        int base;
        int power;
        long value;

        public Index(int base, int power) {
            this.base = base;
            this.power = power;
            this.value = (long)Math.pow(base, power);
        }
    }

    public static void main(String[] args) {
        PowersIterator iterator = new PowersIterator();
        for (int i = 1; i <=8; ++i) {
            for (int j = 1; j <=i; ++j) {
                System.out.println(iterator.next());
            }
            System.out.println("-------");
            iterator.reset();
        }
    }

}
