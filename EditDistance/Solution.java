public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][] ar = new int [word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
            ar[i][0]=i;
        for(int j=0;j<=word2.length();j++)
            ar[0][j]=j;
        for(int i=1;i<=word1.length();i++)
        {
            for(int j=1;j<=word2.length();j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    ar[i][j]=ar[i-1][j-1];
                else
                {
                    int mn=Math.min(ar[i-1][j],ar[i][j-1]);
                    ar[i][j]=1+Math.min(ar[i-1][j-1],mn);
                }
            }
        }
        return ar[word1.length()][word2.length()];   
    } 
}
