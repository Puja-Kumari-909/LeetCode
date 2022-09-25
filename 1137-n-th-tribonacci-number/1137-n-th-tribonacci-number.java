class Solution {
    public int tribonacci(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return helper(n, dp);
    }
    
    private int helper(int n, int[] dp){
        if(n==2) return 1;
        if(n==1) return 1;
        if(n==0) return 0;
        
        if(dp[n] != -1) return dp[n];
        
        int prev = helper(n-1, dp);
        int secondPrev = helper(n-2, dp);
        int thirdPrev = helper(n-3, dp);
        
        return dp[n] = prev + secondPrev + thirdPrev;
    }
}