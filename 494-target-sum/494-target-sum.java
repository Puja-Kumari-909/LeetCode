class Solution {
    
    int totalSum = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
      
        for(int num : nums){
            totalSum += num;
        }
        
        int[][] dp = new int[n+1][2*totalSum+1];
        
        for(int[] ar : dp){
            Arrays.fill(ar, Integer.MIN_VALUE);
        }
        
        return helper(0, 0, nums, target, dp);
    }
    
    private int helper(int ind, int sum, int[] nums, int target, int[][] dp){
        
        if(ind>=nums.length){
            if(sum == target)
                return 1;
            else
                return 0;
        }
        
        // need to shift the index of sum bcz sum can go -ve and array ind cant go -ve thats why we shift the index by total sum
        if(dp[ind][sum+totalSum] != Integer.MIN_VALUE) return dp[ind][sum+totalSum];
    
        int add = helper(ind+1, sum + nums[ind], nums, target, dp);
        int subtract = helper(ind+1, sum - nums[ind], nums, target, dp);
        
        return dp[ind][sum+totalSum] = add+subtract;
    }
}