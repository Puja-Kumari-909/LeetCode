class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
        }
        
        for(int i=1; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]>nums[j]){
                    int lengthOfLis = dp[j] + 1;
                    dp[i] = Math.max(dp[i], lengthOfLis);
                }
            }
        }
        
        int maxLengthLis = dp[0];
        
        for(int num : dp){
            maxLengthLis = Math.max(num, maxLengthLis);
        }
        
        return maxLengthLis;
    }
}