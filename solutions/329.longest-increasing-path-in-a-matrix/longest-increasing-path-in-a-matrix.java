class Solution {
    int maxLen = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, dp, i, j);
            }
        }
        return maxLen;
    }
    public void dfs(int[][] matrix, int[][] dp, int x, int y){
        if (dp[x][y] != 0) return;
        int m = matrix.length, n = matrix[0].length;
        int[][] dxy = {{1,0}, {-1,0}, {0,1}, {0,-1}};   
        int max = 1;
        for (int[] d : dxy) {
            int nx = x + d[0], ny = y + d[1];
            int len = 1;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[x][y] < matrix[nx][ny]) {
                dfs(matrix, dp, nx, ny);
                len = 1 + dp[nx][ny];
            }
            max = Math.max(max, len);
        }
        dp[x][y] = max;
        maxLen = Math.max(maxLen, max);
    }
}