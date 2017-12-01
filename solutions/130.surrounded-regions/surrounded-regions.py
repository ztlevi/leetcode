class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        m = len(board)
        n = len(board[0])
        ans = [['X'] * n for _ in range(m)]
        for i in (0, m - 1):
            for j in range(n):
                self.fill(board, i, j, ans)
        for i in range(1, m-1):
            for j in (0, n - 1):
                self.fill(board, i, j, ans)
        
        for i in range(m):
            for j in range(n):
                board[i][j] = ans[i][j]

    def fill(self, board, x, y, ans):
        m = len(board)
        n = len(board[0])
        if 0 <= x < m and 0 <= y < n and board[x][y] == 'O':
            ans[x][y] = 'O'
            board[x][y] = 'X'
            for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
                nx = x + dx
                ny = y + dy
                self.fill(board, nx, ny, ans)

# so = Solution()
# so.solve([["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]])