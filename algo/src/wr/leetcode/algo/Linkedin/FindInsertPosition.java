package wr.leetcode.algo.Linkedin;

public class FindInsertPosition {
    char findInsPoint(String sortedString, char x)
    {
        //assert not null sortedString not empty
        char [] arr = sortedString.toCharArray();
        int start = 0;
        int n = arr.length;
        int end = n-1;

        int find = 0;
        while (start <= end) {
            int mid = start + ((end-start) >>1);
            char ch = arr[mid];
            if ( ch == x) {
                find = (mid + 1)%n;
                start = mid + 1;
            } else if (ch < x) {
                start = mid+1;
            } else { // ch > x
                find = mid;
                end = mid-1;
            }
        }
        return arr[find];
    }
}
