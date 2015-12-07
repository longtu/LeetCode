package wr.leetcode.algo.read_n_characters_given_read4;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

import java.util.Arrays;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        int read = 0;
        char[] cache = new char[4];
        boolean finished = false;

        do {
            int count = read4(cache);
            if(count > 0) {
                //trim to n if necessary
                if( read + count > n) {
                    count = n - read;
                    finished = true;
                }
                //BUG: this should be after read!
                System.arraycopy(cache, 0, buf, read, count);
                read += count;
            } else {
                finished = true;
            }
        } while( !finished);
        return read;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] dest = new char[1];

        System.out.println(sol.read(dest, 1));
        System.out.println(Arrays.toString(dest));


    }
}

class Reader4{
    int read4(char[] buf) {
        buf[0] = 'a';
        return 1;
    }


}