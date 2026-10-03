class Solution {
    public int closedIsland(int[][] grid) {
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    if(helper(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean helper(int[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length){
            return false;
        }

        if(grid[row][col]==1){
            return true;
        }   
        
        grid[row][col]=1;

        boolean down = helper(grid,row+1,col);
        boolean up = helper(grid,row-1,col);
        boolean right = helper(grid,row,col+1);
        boolean left = helper(grid,row,col-1);

        return down && up && right && left;
    }
}