class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
    	if s1 is None:
    		s1 = ""
    	if s2 is None:
    		s2 = ""
    	if s3 is None:
    		s3 = ""

    	len1 = len(s1)
    	len2 = len(s2)
    	len3 = len(s3)

    	if (len1 + len2) != len3:
    		return False
    	#!!! len2+1 len1+1 here!!!	
    	glo = [[ False for x in xrange(len2+1)] for y in xrange(len1+1)]

    	for i in xrange(len1+1):
    		for j in xrange(len2+1):
    			if i == 0 and j == 0 :
    				glo[i][j] = True
    				continue
    			if i > 0:
    				glo[i][j] = glo[i][j] or (glo[i-1][j] and s1[i-1] == s3[i+j-1])
    			if j > 0:
    				glo[i][j] = glo[i][j] or (glo[i][j-1] and s2[j-1] == s3[i+j-1])

    	return glo[len1][len2]

if __name__ == '__main__':
	sol = Solution()
	print sol.isInterleave("aabcc","dbbca","aadbbcbcac")
	print sol.isInterleave("aabcc","dbbca","aadbbbaccc")