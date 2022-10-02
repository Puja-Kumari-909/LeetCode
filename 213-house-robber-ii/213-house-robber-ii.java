class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if(n==1) return nums[0];
        
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        
        dp1[0] = nums[0];
        dp2[1] = nums[1];
        
        for(int i=1; i<=n-2; i++){
            
            int notTake = 0 + dp1[i-1];
        
            int take = Integer.MIN_VALUE;
            
            if(i-2 >= 0)
                take = nums[i] + dp1[i-2];

            dp1[i] = Math.max(take, notTake);
        }
        
        for(int j=2; j<=n-1; j++){
            
            int notTake = 0 + dp2[j-1];
        
            int take = Integer.MIN_VALUE;
            
            if(j-2 >= 0)
                take = nums[j] + dp2[j-2];

            dp2[j] = Math.max(take, notTake);
        }
        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
    
//     private int helper(int ind, int end, int[] nums, int[] dp){
        
//         if(ind < end) return 0;
        
//         if(ind == end)
//             return nums[ind];
        
//         if(dp[ind] != -1) return dp[ind];
        
//         int notTake = 0 + helper(ind-1, end, nums, dp);
        
//         int take = nums[ind] + helper(ind-2, end, nums, dp);
    
//         return dp[ind] = Math.max(take, notTake);
//     }
}