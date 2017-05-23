public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        if (m < 0) return false;
        int n = matrix[0].length - 1;
        if (n < 0) return false;
        
        int i = m, j = 0;

        while (i >=0 && j <= n) {
            if (target < matrix[i][j])
                i--;
            else if (target > matrix[i][j])
                j++;
            else return true;
        }
        return false;
    }
}
