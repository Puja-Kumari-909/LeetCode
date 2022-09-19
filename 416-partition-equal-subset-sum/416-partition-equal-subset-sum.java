class Solution {
    public boolean canPartition(int[] nums) {
        
        int totalSum = Arrays.stream(nums).sum();
        int n = nums.length;
        
        if(totalSum % 2 != 0) return false;
        
        Boolean[][] dp = new Boolean[n+1][totalSum+1];
        
        int target = totalSum/2;
        
        return helper(0, 0, target, nums, dp);
    }
    
    private boolean helper(int ind, int sum, int target, int[] nums, Boolean[][] dp){
        
        if(ind >= nums.length){
            if(sum == target) 
                return true;
            else 
                return false;
        }
        
        if(dp[ind][sum] != null) return dp[ind][sum];
        
        boolean take = helper(ind+1, sum + nums[ind], target, nums, dp);
        boolean dontTake = helper(ind+1, sum, target, nums, dp);
        
        return dp[ind][sum] = take || dontTake;
    }
}