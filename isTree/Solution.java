boolean canCombine(String a, String b, String c){
    
    if(a == null)
        return (b == c);
    if(b == null)
        return (a == c);
    if(c == null)
        return (a.length() == b.length()) &&( b.length() == 0);
    if (c.length() != (a.length() + b.length()))
        return false;

    char [] arrayA = a.toCharArray();
    char [] arrayB = b.toCharArray();
    char [] arrayC = c.toCharArray();
    int lenA = arrayA.length();
    int lenB = arrayB.length();
    int lenC = arrayC.length();

    boolean [][] dp = new boolean [2][lenB+1];
    for(int i = 0; i<2; ++i)
        dp[i] new boolean[lenB+1];

    for(int i = 0; i <= lenA; ++i)
        for(int j = 0; j<= lenB; ++j){
            if(i == j && j == 0){
                boolean [i][j] = 0;
                continue;
            }
            boolean res = false;
            if(i > 0)
                res |=  dp[(i-1)%2][j] && (arrA[i-1] == arrayC[i+j-1])
            
            if(j >0)
                res |=  dp[i%2][j-1] && (arrB[j-1] == arrayC[i+j-1]);
            dp[i][j] = res;
        }

    return dp[lenA%2][lenB];

}
