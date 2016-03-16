package wr.leetcode.algo.Facebook;

import java.util.*;

/**
 *
 *  1. Given data structure (internally sorted) supports three APIs:
    pop() randomly pops first/last element
    peek() randomly peeks first/last element
    isEmpty()
    Build a datastructure that can pull all elements from it in order.
    Follow ups: what if there is no peek()?
 *
 *
 *
 *
 *
 *
 */
public class RandomListSorted {

    static boolean sorted( List<Integer> list ) {
        List<Integer> copy = new LinkedList<>(list);
        Collections.sort(copy);
        return copy.equals(list);
    }

    public static void main(String[] args) {
        RandomListSorted sol = new RandomListSorted();

        for (int n = 0; n < 100; ++n) {
            System.out.println(sorted(sol.sortV1(new RandomList(n))));
            System.out.println(sorted(sol.sortV2(new RandomList(3))));
        }
    }

    /**
     * peek allowed
     */
    List<Integer> sortV1( RandomList randomList) {
        List<Integer> head = new LinkedList<>();
        List<Integer> tail = new LinkedList<>();
        while (!randomList.isEmpty()) {
            int n = randomList.pop();
            if(randomList.isEmpty() || n < randomList.peek()) {
                head.add(n);
            } else {
                tail.add(0,n);
            }
        }
        while(!tail.isEmpty()) {
            head.add(tail.remove(0));
        }
        return head;
    }

    /**
     * peek not allowed
     */
    List<Integer> sortV2( RandomList randomList) {
        List<Integer> head = new LinkedList<>();
        List<Integer> tail = new LinkedList<>();

        List<Integer> buffer = new LinkedList<>();
        while (!randomList.isEmpty()) {
            buffer.add(randomList.pop());
            if(buffer.size() == 3) {
                int v = buffer.get(2);
                for (int i = 2; i >0; --i) {
                    int n = buffer.remove(0);
                    if(n < v) {
                        head.add(n);
                    } else {
                        tail.add(0, n);
                    }
                }
            }
        }
        if(buffer.size() == 2 && buffer.get(1) < buffer.get(0)) {
            buffer.add(buffer.remove(0));
        }
        head.addAll(buffer);
        while(!tail.isEmpty()) {
            head.add(tail.remove(0));
        }
        return head;
    }

}

class RandomList {
    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<>();
    public RandomList(int n) {
        for (int i = 1; i <=n; ++i) {
            list.add(i);
        }
    }

    int pop() {

        int ret;
        if(random.nextDouble() > 0.5) {
            ret = list.remove(0);
        } else {
            ret = list.remove(list.size()-1);
        }
        return ret;
    }

    int peek() {
        int ret;
        if(random.nextDouble() > 0.5) {
            ret = list.get(0);
        } else {
            ret = list.get(list.size() - 1);
        }
        return ret;
    }

    boolean isEmpty() {
        return list.isEmpty();
    }
}

