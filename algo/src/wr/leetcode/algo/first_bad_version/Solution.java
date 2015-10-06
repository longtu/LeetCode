package wr.leetcode.algo.first_bad_version;

class VersionControl {
    boolean isBadVersion(int version) {
        return true;//TODO: add implementation
    }
}

//TODO: A LOT OF EDGE CASES!!! WHAT IF NO FIRST ONE?
 public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int found = -1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(isBadVersion(mid)){
                end = mid - 1;
            } else if (mid + 1 > n) {
                break;
            } else if(!isBadVersion(mid + 1)) {
                start = mid + 1;
            } else {
                found = mid;
            }
        }
        return (found == -1) ? (-1):(found + 1);
    }
}