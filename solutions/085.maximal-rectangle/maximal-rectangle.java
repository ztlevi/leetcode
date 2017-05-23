class Solution {
    	public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        int[][] height = new int[m][n+1];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = (i == 0) ? 1 : height[i-1][j]+1;
                }
            }
        }
        
        // height[][] one more colum
        // 1 0 1 0 0 0
        // 2 0 2 1 1 0
        // 3 1 3 2 2 0
        // 4 0 0 3 0 0
        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
	}
	
	    private int maxAreaInHist(int[] height) {
        LinkedList<Integer> stack = new LinkedList();
        int i = 0; int max = 0;

        // for 3, 1, 3, 2, 2, 0. 
        // calculate max when pop()
        // push(3), pop(), push(1), push(3), pop(), push(2), push(2), pop(), push(0).
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
                i++;
            } else {
                int t = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() -1);
                max = Math.max(max, height[t] * width);
            }
        }

        return max;
    }

};