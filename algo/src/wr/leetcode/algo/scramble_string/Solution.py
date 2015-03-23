class Solution:
    # @return a boolean
    def isScramble(self, s1, s2):
        if s1 is None:
        	s1 = ""
        if s2 is None:
        	s2 = ""

        len1 = len(s1)
        len2 = len(s2)

        if len1 != len2 :
        	return False
        LEN = len1

        sol = [[[False for x in range(LEN)] for x in range(LEN)] for x in range (LEN)]

        for l in range(1,LEN+1):
        	for m in range(LEN+1-l):
        		for n in range(LEN+1-l):
        			if s1[m:m+l] == s2[n:n+l]:
        				sol[l-1][m][n] = True
        				continue
        			for x in range(1,l):
        				####!!! sol[x-1][][] !!!
        				if sol[x-1][m][n] and sol[l-x-1][m+x][n+x]:
        					sol[l-1][m][n] = True
        					####!!! break here !!!
        					break;
        				elif sol[x-1][m][n+l-x] and sol[l-x-1][m+x][n]:
        					sol[l-1][m][n] = True
        					break;

        return sol[LEN-1][0][0]

if __name__ == '__main__':
	sol = Solution()
	print sol.isScramble("rgtae", "great")