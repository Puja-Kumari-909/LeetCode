class Solution {
    public int fib(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return helper(n, dp);
    }
    
    private int helper(int n, int[] dp){
        
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        
        if(dp[n] != -1)
            return dp[n];
        
        int prev = helper(n-1, dp);
        int secondPrev = helper(n-2, dp);
        
        return dp[n] = prev + secondPrev;
    }
}