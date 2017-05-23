public class Solution {
public int numIslands(char[][] grid) {
    if(grid.length==0||grid[0].length==0) return 0;
    int row = grid.length;
    int colum = grid[0].length;
    int count=0;
    
    for(int i=0; i<row; i++){
        for(int j=0; j<colum; j++){
            if(grid[i][j]=='1'){
                count++;
                dfs(grid, i, j);
            }
        }
    }
    return count;
}

public void dfs(char[][] grid, int i, int j){
    int row = grid.length;
    int colum = grid[0].length;
    
    if(i<0||i>row-1||j<0||j>colum-1||grid[i][j]!='1')
        return;
    
    grid[i][j] = 'N';
    dfs(grid,i-1,j);
    dfs(grid,i+1,j);
    dfs(grid,i,j-1);
    dfs(grid,i,j+1);
}
}