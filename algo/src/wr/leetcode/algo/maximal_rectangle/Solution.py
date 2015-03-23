class Solution:
    # @param matrix, a list of lists of 1 length string
    # @return an integer
    def maximalRectangle(self, matrix):
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0 :
            return 0;

        height = len(matrix)
        width = len(matrix[0])
        s = [ [0 for x in range(width)] for x in range(height)]

        maxArea = 0
        for dist in range(height):
            for i in range(height-dist):
                l = 0
                for j in range(0, width):
                    if dist == 0 and matrix[i+dist][j] == '1':
                        l += 1
                    elif s[i][j] > 0 and matrix[i+dist][j] == '1':
                        l += 1
                    else:
                        l = 0
                    s[i][j] = l
                maxArea = max(maxArea,max(s[i])*(dist+1))
        return maxArea

if __name__ == '__main__':
    sol = Solution()
    matrix = [
    ['1'],
    ]
    print sol.maximalRectangle(matrix)