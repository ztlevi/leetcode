public class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;       
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                int[] x = {-1,-1,-1,0,0,1,1,1};
                int[] y = {-1,0,1,-1,1,-1,0,1};
                int X, Y;
                for (int k = 0; k < 8; k++) {
                    X = i + x[k];
                    Y = j + y[k];
                    if (X>=0 && X<n && Y>=0 && Y<m && (board[X][Y]&1) == 1)
                        count++;
                }

                if (count < 2) {
                    board[i][j] &= 1;
                } else if (count == 2 || count == 3) {
                    board[i][j] |=board[i][j]<<1;
                } else if (count > 3) {
                    board[i][j] &= 1;
                }
                if (count == 3) {
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}