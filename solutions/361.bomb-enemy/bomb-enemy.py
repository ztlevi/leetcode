class Solution(object):
    def maxKilledEnemies(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # corner case
        if not grid or not grid[0]:
            return 0

        n, m = len(grid), len(grid[0])
        ret = 0
        rowE, colE = 0, [0]*m
        for i in range(n):
            for j in range(m):
                if j == 0 or grid[i][j-1] == 'W':
                    rowE = 0
                    for k in range(j, m):
                        if grid[i][k] != 'W':
                            if grid[i][k] == 'E':
                                rowE += 1 
                        else:
                            break
                            
                if i == 0 or grid[i-1][j] == 'W':
                    colE[j] = 0
                    for k in range(i, n):
                        if grid[k][j] != 'W':
                            if grid[k][j] == 'E':
                                colE[j] += 1
                        else:
                            break
                                
                if grid[i][j] == '0':
                    ret = max(ret, rowE + colE[j])

        return ret