
class Solution:
	# xrange difference

	def sum_profit(self, prices):
		prices_l = prices[:-1]
		prices_r = prices[1:]
		ret = sum( (y-x) for x, y in zip(prices_l, prices_r) if y > x)
		return ret

	def max_profit(self, k, prices):
		if k <= 0 or prices is None or len(prices) == 0:
			return  0
		days = len(prices)

		if k > days-1:
			print k, days
			return self.sumProfit(prices)

		glb = [[0 for y in range(days)] for x in range(2)]
		loc = [[0 for y in range(days)] for x in range(2)]

		tran = 1
		while tran < k+1:
			for day in range(1, days):
				diff = prices[day] - prices[day -1]
				loc[tran%2][day] = max ( loc[tran%2][day-1] + diff, 
					glb[(tran-1)%2][day-1] + max( diff, 0) )

				glb[tran%2][day] = max ( glb[tran%2][day-1], loc[tran%2][day])
			tran +=1
		print glb
		return glb[k%2][days-1]

if __name__ == '__main__':
	prices =  [3,3,5,0,0,3,1,4]
	print Solution().max_profit(2, prices);