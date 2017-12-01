class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m-1, i);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    ans.add(new int[]{i, j});
            }
        }
        return ans;
    }
    

    public void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j){
        int m = matrix.length, n = matrix[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || height > matrix[i][j])
            return;
        int[][] dxy = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};

        visited[i][j] = true;
        for (int[] d : dxy) {
            dfs(matrix, visited, matrix[i][j], i + d[0], j + d[1]);
        }
    }
}