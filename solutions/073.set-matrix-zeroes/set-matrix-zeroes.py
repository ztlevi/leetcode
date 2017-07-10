class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not (matrix or matrix[0]):
            return [[]]
        m = len(matrix)
        n = len(matrix[0])
        firstRowHasZero = not all(matrix[0])
        firstColumnHasZero = False
        for i in range(m):
            if matrix[i][0] == 0:
                firstColumnHasZero = True
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[0][j] = matrix[i][0] = 0
        
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
        
        if firstRowHasZero:
            matrix[0] = [0]*n
        if firstColumnHasZero:
            for i in range(m):
                matrix[i][0] = 0