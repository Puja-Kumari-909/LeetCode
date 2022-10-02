class Solution {
    
    int MOD = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] dp = new int[n+1][target+1];
        
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        return helper(n, k, target, dp);
    }
    
    private int helper(int dice, int faces, int target, int[][] dp){
        
        if(target < 0) return 0;
        
        if(dice == 0 && target != 0)
            return 0;
        
        if(target == 0 && dice != 0)
            return 0;
        
        if(target == 0 && dice == 0)
            return 1;
        
        if(dp[dice][target] != -1) return dp[dice][target];
        
        int ans = 0;
        
        for(int i=1; i<=faces; i++){
            ans = (ans + helper(dice - 1, faces, target-i, dp)) % MOD;
        }
        
        return dp[dice][target] = ans;
    }
}