class Solution:
	def compareVersion(self, version1, version2):
		lefts = map(int, version1.split('.'))
		rights = map(int, version2.split('.'))

		if len(lefts) < len(rights) :
			return -1* self.compareVersion(version2,version1)

		rights_append = [0 for x in range(len(lefts))]
		rights_append[:len(rights)] = rights
		
		diff = [ x-y for x, y in zip(lefts,rights_append) if x != y]
		diff.append(0);

		value = diff[0];
		if value > 0:
			return 1
		elif value < 0:
			return -1
		else:
			return 0


	def main(self):
		print self.compareVersion("1.0", "1.1")

if __name__ == '__main__':
	Solution().main()