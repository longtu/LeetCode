class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
    	start = 0
    	end = len(num)-1

    	while start + 1 < end:
    		if num[start] == num[end] :
    			start += 1
    		else:
    			start += 1
    			end -=1

    	return num[start]

if __name__ == '__main__':
	sol = Solution();
	num = [1];
	print sol.majorityElement(num)
	num = [2,2];
	print sol.majorityElement(num)
	num = [2,3,2];
	print sol.majorityElement(num)
	num = [2,3,2,2];
	print sol.majorityElement(num)