class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
    	last = None
    	count = 0
    	for i in range(len(num)):
    		if num[i] == last:
    			count += 1
    		elif count ==0:
    			count += 1
    			last= num[i]
    		else:
    			count -= 1
    	return last

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