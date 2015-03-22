class Solution:
    # @return an integer
    def minDistance(self, word1, word2):
   	if word1 is None:
   		word1 = ""
   	if word2 is None:
   		word2 = ""

   	m = len(word1)
   	n = len(word2)

   	sol = [ [ 0 for y in xrange(n+1)] for i in xrange(2)]

   	i = 0
   	while i < m+1:
   		for j in xrange(n+1):
   			sol [i%2][j] = max(i,j);
   			if i > 0:
   				sol[i%2][j] = min (sol[i%2][j], sol[(i-1)%2][j] +1)
   			if j > 0:
   				sol[i%2][j] = min (sol[i%2][j], sol[i%2][j-1]+1)
   			if i > 0 and j > 0 :
   				diff = 1
   				if word1[(i-1)%2] == word2[j-1]:
   					diff = 0
   				sol[i%2][j] = min (sol[i%2][j], sol[(i-1)%2][j-1] + diff)
   		i += 1
   	return sol[m%2][n]

if __name__ == '__main__':
	sol = Solution()
	print sol.minDistance("", "")
	print sol.minDistance("a", "")
	print sol.minDistance("", "ab")
	print sol.minDistance("baab", "aa")
	print sol.minDistance("abab", "baba")