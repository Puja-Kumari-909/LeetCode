class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1; i<=n; i++){
             for(int j=1; j*j <= n; j++){
                 int sqrtNum = j*j;
                 if(i-sqrtNum>=0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - sqrtNum]);
            }
        }
        
        return dp[n];
    }
    
//     public int helper(int n, int[] dp){
//         if(n==0)
//             return 0;
        
//         if(dp[n]!=-1)
//             return dp[n];
        
//         int ans = Integer.MAX_VALUE; 
        
//         for(int i=1; i*i <= n; i++){
//             int sqrtNum = i*i;
//             ans = Math.min(ans, 1+helper(n-sqrtNum, dp));
//         }
        
//         return dp[n] = ans;
//     }
}