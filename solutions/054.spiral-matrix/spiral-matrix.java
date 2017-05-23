public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = (n == 0) ? 0 : matrix[0].length;
        List<Integer> ans = new LinkedList();
        int rowStart = 0, columStart = 0, rowEnd = n-1, columEnd = m-1;
        
        while(rowStart <= rowEnd && columStart <= columEnd) {
            int i = rowStart, j = columStart;
            for(; j <= columEnd; j++) {
                ans.add(matrix[i][j]);
            }
            rowStart++; j--;
            
            if(rowStart > rowEnd) break;
            
            for(i = rowStart; i <= rowEnd; i++) {
                ans.add(matrix[i][j]);
            }
            columEnd--; i--;
            
            if(columStart > columEnd) break;
            
            for(j = columEnd; j >= columStart; j--) {
                ans.add(matrix[i][j]);
            }
            rowEnd--; j++;
            
            if(rowStart > rowEnd) break;

            for(i = rowEnd; i >= rowStart; i--) {
                ans.add(matrix[i][j]);
            }
            columStart++; i++;
        }
        return ans;
    }
}