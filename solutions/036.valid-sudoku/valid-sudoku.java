public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // block search
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                // get the init (X, Y) of each block
                int initX = i*3, initY = j*3;
                Set<Character> set = new HashSet();
                
                for(int x = 0; x < 3; x++) {
                    for(int y = 0; y < 3; y++) {
                        int X = initX+x, Y = initY+y;
                        if(board[X][Y] != '.') {
                            if(set.isEmpty()) {
                                set.add(board[X][Y]);
                            } else if(set.contains(board[X][Y])) {
                                return false;
                            }
                            else set.add(board[X][Y]);
                        }
                    }
                }
            }
        }
        
        // line search
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(set.isEmpty()) {
                        set.add(board[i][j]);
                    } else if(set.contains(board[i][j])) {
                        return false;
                    }
                    else set.add(board[i][j]);
                }
            }
        }
        
        // colum search
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet();
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(set.isEmpty()) {
                        set.add(board[j][i]);
                    } else if(set.contains(board[j][i])) {
                        return false;
                    }
                    else set.add(board[j][i]);
                }
            }
        }
        
        return true;
    }
}