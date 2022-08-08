class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length+1];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return helper(nums, 0, -1, dp);
    }
    
    public int helper(int[] nums, int ind, int prev_ind, int[][] dp){
        
        if(ind>=nums.length){
            return 0;
        }
        
        if(dp[ind][prev_ind+1] != -1) return dp[ind][prev_ind+1];
        
        int pick = 0;
        int notPick = 0;
        
        notPick = 0 + helper(nums, ind+1, prev_ind, dp);
        
        if(prev_ind == -1 || nums[prev_ind]<nums[ind]){
            pick = 1 + helper(nums, ind+1, ind, dp);
        }
        
        return dp[ind][prev_ind+1] = Math.max(notPick, pick);
    }
}