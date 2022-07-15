class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] != 0)
                    max = Math.max(max, helper(i, j, grid));
            }
        }
        return max;
    }
    
    public int helper(int i, int j, int[][] grid){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        
        return 1 + helper(i, j-1, grid) + helper(i, j+1, grid) + helper(i-1, j, grid) + helper(i+1, j, grid);
    }
}