public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0) return 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    helper(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void helper(char[][] board, int i, int j) {
        board[i][j] = '.';
        if (i+1 < board.length && board[i+1][j] == 'X')
            helper(board, i+1, j);
        else if(j+1 < board[0].length && board[i][j+1] == 'X')
            helper(board, i, j+1);
    }
}