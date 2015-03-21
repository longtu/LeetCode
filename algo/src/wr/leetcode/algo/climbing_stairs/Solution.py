class Solution:
	def climbStairts(self, n):
		sol = [1,0,0]
		i = 1;

		while i <= n:
			ret = 0
			if i >=1 :
				ret += sol[(i-1)%3]
			if i >=2 :
				ret += sol[(i-2)%3]
			sol[i%3] = ret
			i += 1
		return sol[n%3]
if __name__ == '__main__':
	print Solution().climbStairts(0)
	print Solution().climbStairts(1)
	print Solution().climbStairts(2)
	print Solution().climbStairts(3)