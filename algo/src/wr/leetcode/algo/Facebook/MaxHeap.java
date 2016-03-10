package wr.leetcode.algo.Facebook;

public class MaxHeap {

    int capacity;
    int[] data;

    public MaxHeap (int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity+1];
        data[0] = 0;
    }


    public int peek () {
        if(isEmpty()) {
            throw new IllegalStateException("empty heap!");
        }
        return data[1];
    }

    public boolean isEmpty() {
        return data[0] > 0;
    }

    private int parent(int idx ) {
        return idx/2;
    }

    private int leftChild(int idx) {
        return idx *2;
    }

    private int rightChild(int idx) {
        return idx*2 + 1;
    }

    // append and heapify up
    public void offer(int value) {
        int size = data[0];
        if(size == capacity) {
            throw new IllegalStateException("No more space");
        }
        data[0]++;
        int idx = data[0];
        data[idx] = value;

        int parent = parent(idx);
        while( parent > 0 && data[parent] < data[idx]) {
            swap(parent, idx);
            idx = parent;
            parent = parent(parent);
        }
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    public int poll() {
        int ret = data[1];
        //move last node to top
        //compare top and its bigger children, until both children are null
        // or bigger than both children
        return ret;
    }

    public void buildHeap() {
        //THIS IS NOT THE SAME AS calling N times offer, which is suboptimal
        // as O(NLog(N))

        //Build-Max-Heap (A): Linear time
        /**
         * heap_length[A] ← length[A]
         *
         * for each index i from floor(length[A]/2) downto 1 do:
                Max-Heapify(A, i)
         */
    }

}
