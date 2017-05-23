public class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if (n < 0) return false;
        int m = board[0].length;
        if (m < 0) return false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j) )
                        return true;
                } 
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int i, int j) {
        if (word.length() == 0) return true;
        int n = board.length;
        int m = board[0].length;
        if (i >= n || i < 0 || j < 0 || j >= m || board[i][j] != word.charAt(0) ) return false;
        board[i][j] = '#'; // mark the borad

        boolean rst = helper(board, word.substring(1, word.length()), i+1, j) ||
            helper(board, word.substring(1, word.length()), i, j+1) ||
            helper(board, word.substring(1, word.length()), i-1, j) ||
            helper(board, word.substring(1, word.length()), i, j-1);
        board[i][j] = word.charAt(0); // resume the board
        return rst;
    }
}
