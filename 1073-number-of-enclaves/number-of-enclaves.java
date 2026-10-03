class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            dfs(grid,i,0);
            dfs(grid,i,col-1);
        }

        for(int j=0;j<col;j++){
            dfs(grid,0,j);
            dfs(grid,row-1,j);
        }

        int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0){
            return;
        }

        grid[row][col]=0;

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}