package wr.leetcode.algo.read_n_characters_given_read4_ii_call_multiple_times;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int read = 0;
        while( read < n ) {
            if(index == bufferSize) {
                bufferSize = read4(buffer);
                index = 0;
            }
            if(index == bufferSize) {
                //no more to read from file
                break;
            } else {
                buf[read++] = buffer[index++];
            }
        }
        return read;
    }
    
    char[] buffer = new char[4];
    int bufferSize = 0;
    int index = 0;
}

class Reader4{
    int read4(char[] buf) {
        buf[0] = 'a';
        return 1;
    }


}