class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if(n==1) return nums[0];
        
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(helper(n-2, 0, nums, dp1), helper(n-1, 1, nums, dp2));
    }
    
    private int helper(int ind, int end, int[] nums, int[] dp){
        
        if(ind < end) return 0;
        
        if(ind == end)
            return nums[ind];
        
        if(dp[ind] != -1) return dp[ind];
        
        int notTake = 0 + helper(ind-1, end, nums, dp);
        
        int take = nums[ind] + helper(ind-2, end, nums, dp);
    
        return dp[ind] = Math.max(take, notTake);
    }
}