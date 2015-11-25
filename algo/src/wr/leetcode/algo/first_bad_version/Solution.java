package wr.leetcode.algo.first_bad_version;

class VersionControl {
    boolean isBadVersion(int version) {
        return true;//TODO: add implementation
    }
}





public class Solution extends VersionControl {


    public int firstBadVersion(int n) {
        int ret = 0;
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + ((end - start)>>1);
            boolean mv = isBadVersion(mid);
            if(1 == mid){
                if(mv) {
                    ret = 1;
                    break;
                } else {
                    start = mid + 1;
                }
            } else {  //mid > 1
                boolean sv = isBadVersion(mid-1);
                if(!sv && mv) {
                    ret = mid;
                    break;
                } else if( !mv ) {
                    start = mid + 1;
                } else { //sv
                    end = mid - 1;
                }
            }
        }
        return ret;
    }


}







/*
//: A LOT OF EDGE CASES!!! WHAT IF NO FIRST ONE?
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
    }*/
