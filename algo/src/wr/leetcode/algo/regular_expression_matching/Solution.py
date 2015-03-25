class Solution:
    # @return a boolean
    def isMatch(self, s, p):
        if s is None:
        	return isMatch("", p)
        if p is None:
        	return isMatch(s, "")

        m = len(p)
        n = len(s)
        dp = [[False for i in range(n+1)] for i in range(m+1)]
        dp[0][0] = True

        for i in range(1, m+1):
        	for j in range(n+1):
        		if p[i-1] == '.' :#####here is also broken
        			if j > 0:
        				dp[i][j] = dp[i-1][j-1]
        			else:
        				dp[i][j] = False
        			continue
        		elif p[i-1] == '*':
        			if p[i-2] == '.':
        				for k in range(j, -1, -1):
        					if dp[i-2][k]:
        						dp[i][j] = True
        						break
        			else:###here: too many edge cases			
        				for k in range(j, -1, -1):
        					if dp[i-2][k] or k == 0:
        						dp[i][j] = dp[i-2][k]
        						break
        					elif s[k-1] != p[i-2]:
        						break
        		else:
        			if j ==0:
        				dp[i][j] = False
        			else:
        				dp[i][j] = dp[i-1][j-1] and p[i-1] == s[j-1]
        print dp
        return dp[m][n]


if __name__ == '__main__':
	sol = Solution()
#	print sol.isMatch("aa", "a")
#	print sol.isMatch("aa", "aa")
##	print sol.isMatch("aa", "a*")
#	print sol.isMatch("aa", ".*")
####print sol.isMatch("", "c*")
print sol.isMatch("a", ".*..a*")
