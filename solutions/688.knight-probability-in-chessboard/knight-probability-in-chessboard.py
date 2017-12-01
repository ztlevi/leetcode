class Solution:
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        dp = [[0] * N for _ in range(N)]
        dp[r][c] = 1
        dlist = [(1, 2), (1, -2), (2, 1), (2, -1), (-1, 2), (-1, -2), (-2, 1), (-2, -1)]
        for cnt in range(K):
            next = [[0] * N for _ in range(N)]
            for i in range(N):
                for j in range(N):
                    if (dp[i][j] >= 1):
                        for dx, dy in dlist:
                            x = dx + i
                            y = dy + j
                            if 0 <= x < N and 0 <= y < N:
                                next[x][y] += dp[i][j]
            dp = next
            
        hit = 0
        for i in range(N):
            for j in range(N):
                hit += dp[i][j]
        return hit / (8 ** K)
                