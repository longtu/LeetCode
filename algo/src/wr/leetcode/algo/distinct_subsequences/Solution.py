class Solution:
    # @return an integer
    def numDistinct(self, S, T):
    	if S is None:
    		S = ""
    	if T is None:
    		T = ""
    	
    	m = len(S)
    	n = len(T)
    	glo = [[0 for i in range(n+1)] for j in range(2)]
    	loc = [[0 for i in range(n+1)] for j in range(2)]

    	for i in xrange(m+1):
    		for j in xrange(n+1):
    			if i == 0 and j == 0:
    				loc[i%2][j] = 1
    			elif i==0 or j == 0:
    				loc[i%2][j] = 0
    			elif S[i-1] == T[j-1] :
    				loc[i%2][j] = glo[(i-1)%2][j-1]
    			else:
    				loc[i%2][j] = 0
    			glo[i%2][j] = loc[i%2][j]

    			if i > 0 :
    				glo[i%2][j] += glo[(i-1)%2][j]
    	return glo[m%2][n]

if __name__ == '__main__':
	sol = Solution()
	print sol.numDistinct("rabbbit", "rabbit")