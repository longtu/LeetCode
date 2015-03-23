class Solution:
    # @param s, a string
    # @return an integer
    def minCut(self, s):
        if s is None:
        	s = ""
        LEN = len(s)
        pal = [[False for i in range(LEN)] for i in range(LEN)]

        for l in range(1, LEN+1):
        	for i in range(0, LEN-l+1):
        		if l == 1:
        			pal[l-1][i] = True
        			continue
        		if l == 2:
        			pal[l-1][i] = s[i]==s[i+1]
        			continue
        		pal[l-1][i] = pal[l-3][i+1] and s[i] ==s[i+l-1]

        glo = [i for i in range(LEN)]

        for i in range(1,LEN):
        	if pal[i][0]:
        		glo[i] = 0
        		continue
           	for l in range(1, i+1):
           		if pal[l-1][i-l+1]:
           			glo[i] = min(glo[i], glo[i-l]+1)
        return glo[LEN-1]


if __name__ == '__main__':
	sol = Solution()
	print sol.minCut("aab")