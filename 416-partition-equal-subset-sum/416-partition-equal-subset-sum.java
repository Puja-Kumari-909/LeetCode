class Solution {
    public boolean canPartition(int[] nums) {
        
        int totalSum = Arrays.stream(nums).sum();
        int n = nums.length;
        
        if(totalSum % 2 != 0) return false;
        
        int target = totalSum/2;
        
        boolean[][] dp = new boolean[n+1][target+1];
        
        dp[0][0] = true;
        
        for(int i=1; i<n; i++)
            dp[i][0] = true;
        
        for(int j=1; j<=target; j++)
            dp[0][j] = false;
        
        for(int ind = 1; ind<=n; ind++){
            for(int tar = 1; tar<=target; tar++){
                if(nums[ind-1] <= tar){
                    dp[ind][tar] = dp[ind-1][tar] || dp[ind-1][tar - nums[ind-1]];
                }else{
                    dp[ind][tar] = dp[ind-1][tar];
                }
            }
        }
        
        return dp[n][target];
    }
}