package wr.leetcode.algo.Linkedin;

import java.util.*;

public class RandomizedArray<T> implements Iterable<T>{
    private T[] nums;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Map<T, Integer> map;

    // Default constructor
    public RandomizedArray() {
        nums = (T[]) new Object[DEFAULT_CAPACITY];
        map = new HashMap<>();
        size = 0;
    }

    // Constructor with initial capacity
    public RandomizedArray(int capacity) {
        nums = (T[]) new Object[capacity];
        map = new HashMap<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Resize the underlying array holding the elements
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = nums[i];
        }

        nums = temp;
    }

    public void add(T val) {
        if (val == null) {
            throw new NullPointerException();
        }

        if (size == nums.length) {
            resize(2 * nums.length);
        }

        nums[size] = val;
        map.put(val, size);

        size++;
    }

    public void remove(T val) {
        if (val == null) {
            throw new NullPointerException();
        }

        // Step 1: get the index of the val
        if (!map.containsKey(val)) {
            throw new NoSuchElementException();
        }

        int index = map.get(val);

        // Step 2: move the last element of the array to the index
        nums[index] = nums[size - 1];
        nums[size - 1] = null;

        // Update the hash map
        map.remove(val);
        map.put(nums[size - 1], index);

        size--;

        // Shrink the array
        if (size > 0 && size == nums.length / 4) {
            resize(nums.length / 2);
        }
    }

    public T removeRandomElement() {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        Random random = new Random();
        int index = random.nextInt(size);
        T val = nums[index];

        remove(val);

        return val;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomizedArrayIterator();
    }

    // Return an independent iterator over times in random order
    private class RandomizedArrayIterator implements Iterator<T> {
        private int i = 0;
        private int[] randIdx;

        public RandomizedArrayIterator() {
            randIdx = new int[size];
            for (int i = 0; i < size; i++) {
                randIdx[i] = i;
            }

            Collections.shuffle(Arrays.asList(randIdx));
        }

        public boolean hasNext() {
            return i < size;
        }

        public T next() {
            T val = nums[randIdx[i]];
            i++;

            return val;
        }
    }
}

