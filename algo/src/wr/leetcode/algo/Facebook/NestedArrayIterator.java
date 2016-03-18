package wr.leetcode.algo.Facebook;

import java.util.Stack;

public class NestedArrayIterator {
    Stack<Info> st = new Stack<>();

    public NestedArrayIterator( NestedArray[] array ) {
        NestedArray root = new NestedArray(array);
        st.push(new Info(root, 0));
        advance();
    }


    /**
     * only top of the stack is data, others are all arrays.
     */
    private void advance() {

        while(!st.isEmpty()) {
            Info info = st.peek();
            NestedArray topNested = info.array;
            int index = info.index;

            if(topNested.isArray) { //is array
                NestedArray[] children = topNested.children;
                int len = children.length;
                if(index >= len) {
                    st.pop();
                } else {
                    NestedArray nextElement = children[index];
                    info.index++;
                    st.push(new Info(nextElement, 0));
                }
            } else { //is not Array
                break;
            }
        }
    }

    public int next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements!");
        }
        Info info = st.pop();
        int ret = info.array.value;
        advance();
        return ret;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }


    public static void main(String[] args) {
        NestedArray a45 = new NestedArray(new NestedArray (4), new NestedArray(5));
        NestedArray a67 = new NestedArray(new NestedArray (6), new NestedArray(7));
        NestedArray a38 = new NestedArray(new NestedArray (3), a45, a67, new NestedArray(8));
        NestedArray a29 = new NestedArray(new NestedArray (2), a38, new NestedArray(9));
        NestedArray[] a110 = {new NestedArray (1), a29, new NestedArray(10)};
        NestedArray [] empty = {new NestedArray( new NestedArray( new NestedArray( new NestedArray())), new NestedArray( new NestedArray(), new NestedArray())),
            new NestedArray()};
        NestedArray[] bundle = {new NestedArray (1), a29, new NestedArray(empty), new NestedArray(10)};

        for (NestedArray[] test : new NestedArray[][] {
                a110, empty, bundle
        } ) {
            NestedArrayIterator iterator = new NestedArrayIterator(test);
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }


    }



    /** model classes **/
    private static class Info {
        NestedArray array;
        int index;

        public Info (NestedArray array, int index) {
            this.index = index;
            this.array = array;
        }
    }

    private static class NestedArray {
        boolean isArray = false;
        int value = -1;
        NestedArray [] children;

        public NestedArray(int value) {
            this.value = value;
        }

        public NestedArray( NestedArray... children) {
            this.isArray = true;
            this.children = children;
        }

    }
}







