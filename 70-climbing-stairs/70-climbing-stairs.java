class Solution {
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    
    private int helper(int n, int[] dp){
        if(n==0 || n==1)
            return 1;
        
        if(dp[n] != -1) return dp[n];
        
        int oneStep = helper(n-1, dp);
        int twoSteps = helper(n-2, dp);
        
        return dp[n] = oneStep + twoSteps;
    }
}