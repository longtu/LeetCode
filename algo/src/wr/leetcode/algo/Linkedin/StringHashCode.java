package wr.leetcode.algo.Linkedin;

public class StringHashCode {



    public int hashCode(char [] value) {

        //int h = hash;
        int h = 0;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            //hash = h;
            // save hash to h to avoid repeated calls.
        }
        return h;
    }

}
