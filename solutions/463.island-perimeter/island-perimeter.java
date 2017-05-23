public class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;

        int perimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    perimeter += checkSurround(grid, i, j);
                }
            }
        }
        return perimeter;
    }
    
    public int checkSurround(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        int count = 0;
        for (int k = 0; k < 4; k++) {
            int X = i + x[k];
            int Y = j + y[k];
            if (X >= 0 && X < n && Y >= 0 && Y < m && grid[X][Y] == 1) {
                count++;
            }
        }
        return 4-count;
    }
}