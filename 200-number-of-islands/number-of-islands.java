class Solution {
    
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols = grid[0].length;
        int islands=0;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    helper(grid, i, j, visited);
                }
            }
        }
        return islands;
    }

    public void helper(char[][] grid,int rows, int cols, boolean[][] visited){
        if(rows<0 || cols<0 || rows>=grid.length || cols>=grid[0].length || grid[rows][cols]=='0' || visited[rows][cols]){
            return;
        }

        visited[rows][cols] = true;

        helper(grid, rows+1, cols, visited);
        helper(grid, rows-1, cols, visited);
        helper(grid, rows, cols+1, visited);
        helper(grid, rows, cols-1, visited);

    }
}