public class Solution {
    // DP(i,j,len) represnets s1(i,i+len-1) and s2(j,j+len-1) are scramble
    // DP(i,j,len) =
    //          if(len == 0) true;
    //
    //          if(len == 1) S1.(i) == S2(j);
    //
    //          else
    //              for(k=1;k<len;++k){
    //                  DP[i,j,k] && DP[i+k,j+k,len-k]
    //                          OR
    //                  DP[i,j+len-k,k] && DP[i+k-1,j,len-k]
    //                                      //ERROR here: DP[i+k]
    //              }
    //
    //
	 public boolean isScramble(String s1, String s2) {
		 	if(s1 == null || s1.isEmpty())
		 		return (s2 == null || s2.isEmpty());
		 	if(s2 == null || s2.isEmpty())
		 		return false;
		 	if(s1.length() != s2.length())
		 		return false;
		 	int LEN = s1.length();
		 	boolean [][][]dp = new boolean [LEN+1][LEN][LEN];
		 	for(int len = 1; len <= LEN; len++)
		 		for(int i = 0; i<LEN-len+1; i++)
		 			for(int j = 0; j<LEN-len+1; j++){
		 				if(len == 1){
		 					dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
		 					continue;
		 				}
	 					dp[len][i][j] = false;
		 				for(int k =1; k<len;k++){
		 					dp[len][i][j] |= ((dp[k][i][j]&& dp[len-k][i+k][j+k])
			 			     ||(dp[k][i][j+len-k]&& dp[len-k][i+k][j])); 
		 				}
		 			}
		 	
		 	return dp[LEN][0][0];
	    }

}
