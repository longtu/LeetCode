public class Solution {
    public int minCut(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int len = s.length();
        char [] arr = s.toCharArray();
        boolean [][] palinMap = new boolean[len][len]; 
        
        for(int i=0; i<len; ++i) {
           palinMap[i][i] = true; 
        }
        for(int d=2;d<=len;++d) {
            for( int i=0; i+d-1<len; ++i){
                int j = i+d-1;
                if(arr[i] != arr[j]){
                    palinMap[i][j] = false;
                    continue;
                }
                if(i+1 > j-1){
                    palinMap[i][j] = true;
                    continue;
                }
                palinMap[i][j] = palinMap[i+1][j-1];
            }
        }

        int [] minCut = new int[len];
        minCut[0] = 0;
        for(int i = 1; i<len; ++i) {
            int thisMinCut = Integer.MAX_VALUE;
            for(int j = 0; j <= i; ++j){
                if( palinMap[j][i]){
                    if(j==0){
                        thisMinCut = 0;
                        continue;
                    }
                    if(minCut[j-1]+1<thisMinCut){
                        thisMinCut = minCut[j-1]+1;
                        continue;
                    }
                }
            }
            minCut[i] = thisMinCut;
        }
        return minCut[len-1];
    }
}
