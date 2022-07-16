class Solution {
    
    int mod = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][][] dp = new int[m][n][maxMove+1];
        
        for(int [][] array : dp){
            for(int[] arr : array){
                Arrays.fill(arr, -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn, dp);
    }
    
    public int helper(int m, int n, int moves, int i, int j, int[][][] dp){
        
        if(i<0 || i>=m || j<0 || j>=n){
            return 1;
        }
        
        if(moves == 0){
            return 0;
        }
        
        if(dp[i][j][moves] != -1)
            return dp[i][j][moves];
        
        return dp[i][j][moves] = ((helper(m, n, moves-1, i-1, j, dp) + helper(m, n, moves-1, i+1, j, dp)) % mod + (helper(m, n, moves-1, i, j-1, dp) + helper(m, n, moves-1, i, j+1, dp)) % mod) % mod;
    }
}