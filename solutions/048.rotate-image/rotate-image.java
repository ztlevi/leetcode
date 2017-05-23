public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        
        int row = matrix.length, colum = matrix[0].length;
        int[][] result = new int[colum][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                result[j][row-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            matrix[i] = result[i];
        }

    }
}