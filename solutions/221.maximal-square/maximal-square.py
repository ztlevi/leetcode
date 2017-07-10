class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        maxLen = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                matrix[i][j] = int(matrix[i][j])
                if matrix[i][j] == 1 and i and j:
                    matrix[i][j] = min(matrix[i-1][j-1], matrix[i-1][j],
                                       matrix[i][j-1]) + 1
                maxLen = max(maxLen, matrix[i][j])
        return maxLen**2