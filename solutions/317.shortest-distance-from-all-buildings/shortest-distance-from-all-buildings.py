class Solution(object):
    def shortestDistance(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or not grid[0]: return -1
        m, n, buildings = len(grid), len(grid[0]), sum(1 for line in grid for val in line if val == 1)
        sumDist, hit = [[0] * n for _ in range(m)], [[0] * n for _ in range(m)]

        def bfs(start_x, start_y):
            visited = [[False] * n  for _ in range(m)]
            visited[start_x][start_y] = True
            countBuildings = 1
            queue = [(start_x, start_y, 0)]
            while queue:
                x, y, dist = queue.pop(0)
                for i, j in ((x+1,y),(x-1,y),(x,y+1),(x,y-1)):
                    if 0 <= i < m and 0 <= j < n and not visited[i][j]:
                        visited[i][j] = True
                        if not grid[i][j]:
                            queue.append((i,j,dist+1))
                            hit[i][j] += 1
                            sumDist[i][j] += dist + 1
                        elif grid[i][j] == 1:
                            countBuildings += 1
            return countBuildings == buildings

        for x in range(m):
            for y in range(n):
                if grid[x][y] == 1:
                    reachable = bfs(x, y)
                    if not reachable:
                        return -1
        minSum = float('inf')
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0 and hit[i][j] == buildings:
                    minSum = min(minSum, sumDist[i][j])
        return minSum if minSum < float('inf') else -1
                    
# so = Solution()
# so.shortestDistance([[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]])
