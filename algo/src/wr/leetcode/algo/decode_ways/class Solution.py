class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
    	n = len(s)
    	if(n <= 0):
    		return 0

    	dic = set(str(i) for i in xrange(1,27))
        decodes = [1 for i in xrange(3)]

        i = 1;
        while i <= n:
        	decodes[i%3] = 0
        	if s[i-1:i] in dic:
        		decodes[i%3] += decodes[(i-1)%3]
        	if s[i-2:i] in dic:
        		decodes[i%3] += decodes[(i-2)%3]
        	i +=1
        return decodes[n%3]

if __name__ == '__main__':
	sol = Solution();
	print sol.numDecodings("12");
	print sol.numDecodings("ab");
	print sol.numDecodings("");