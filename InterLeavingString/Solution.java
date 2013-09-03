//Define:
//M[i, j] (i >=0, j>=0) represents substring of S1 with length i and  and substring of S2 with length j matches substring of C with length (i+j)
//
//M[i,j]:
//
//
//if(i == 0 && j == 0), M[i][j] = true;
//else if(i == 0 )
//      if(S2.charAt(j-1) == C.charAt(j-1))
//          M[0,j] = M[0,j-1];
//      else
//          M[0,j] = false;
//else if(j == 0 )
//      if(S1.charAt(i-1) == C.charAt(i-1))
//          M[i,0] = M[i-1,0];
//      else
//          M[i,0] = false;
//else
//      if(S1.charAt(i-1) == C.charAt(i+j-1))
//          M[i,j] = M[i-1,j]
//      if(S2.charAt(j-1) == C.charAt(i+j-1))
//          M[i,j] = M[i,j-1]
// final Result: M[i,j]
// The recursion process is only related to one step earlier left and above results, therefore we can leverage two one-dimension DP results insted of one two-dimension DP
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
        // Start typing your Java solution below
        // DO NOT write main() function=
       if(s3.length()!=s1.length()+s2.length()) return false;    
        
       boolean []matchUp = new boolean [s1.length()+1];
       boolean []matchLeft = new boolean [s2.length()+1];
       boolean match = true; This initialized value might matters
       
       for(int i=0;i<=s1.length();i++){
           for(int j=0;j<=s2.length();j++){
               
               if (i==0 && j==0) {
                    matchUp[0]=true;
                    matchLeft[0]=true;
                    continue;
               }
            match = false;
                char c = s3.charAt(i+j-1);
               if(i>=1)
                 match |= (matchLeft[j] && c==s1.charAt(i-1)) ;
               if(j>=1)
                 match |= (matchUp[i] && c==s2.charAt(j-1)) ;
               matchLeft[j] = match;
               matchUp[i] = match;
           }
       }
           return match;

    }
}
//One step further optimization
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
        // Start typing your Java solution below
        // DO NOT write main() function=
       if(s3.length()!=s1.length()+s2.length()) return false;    
        
       boolean matchUp = false;
       boolean []matchLeft = new boolean [s2.length()+1];
       boolean match = true;
       
       for(int i=0;i<=s1.length();i++){
           for(int j=0;j<=s2.length();j++){
               
               if (i==0 && j==0) {
                    matchUp =true;
                    matchLeft[0]=true;
                    continue;
               }
            match = false;
                char c = s3.charAt(i+j-1);
               if(i>=1)
                 match |= (matchLeft[j] && c==s1.charAt(i-1)) ;
               if(j>=1)
                 match |= (matchUp && c==s2.charAt(j-1)) ;
               matchLeft[j] = match;
               matchUp  = match;
           }
       }
           return match;

    }
}
