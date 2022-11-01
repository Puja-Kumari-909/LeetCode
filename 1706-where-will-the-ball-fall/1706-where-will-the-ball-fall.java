class Solution {
    public int[] findBall(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[] ans = new int[cols];
        int[][] dp = new int[rows][cols];
        
        for(int[] arr : dp)
            Arrays.fill(arr, -2);
        
        for(int col=0; col<cols; col++)
            ans[col] = dfs(grid, 0, col, dp);
        
        return ans;
    }
    
    
    private int dfs(int[][] grid, int i, int j, int[][] dp){
        
        if(i == grid.length)
            return j;
        
        if(dp[i][j] != -2)
            return dp[i][j];
            
        if(j<0 || j>=grid[0].length)
            return -1;
        
        if(grid[i][j] == 1 && j+1<grid[0].length && grid[i][j+1] == 1)
            return dp[i][j] = dfs(grid, i+1, j+1, dp);
        
        else if(grid[i][j] == -1 && j-1>=0 && grid[i][j-1] == -1)
            return dp[i][j] = dfs(grid, i+1, j-1, dp);
        
        return -1;
    } 
}
