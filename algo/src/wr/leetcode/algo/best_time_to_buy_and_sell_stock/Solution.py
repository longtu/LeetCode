class Solution:
	# @param prices, a list of integer
    # @return an integer

	def maxProfit(self, prices):
		n = len(prices)
		if n <=0 :
			return 0
		glo = [0 for x in xrange(n)]
		loc = [0 for x in xrange(n)]

		t = 1
		while t < n:
			diff = prices[t] - prices[t-1]
			loc[t] = max(diff, diff + loc[t-1])
			glo[t] = max(glo[t-1], loc[t])
			t+=1
		return glo[n-1] 


	def main(self):
		prices = [1,3,-5,6,7,1]
		print self.maxProfit(prices)


if __name__ == '__main__':
	Solution().main()