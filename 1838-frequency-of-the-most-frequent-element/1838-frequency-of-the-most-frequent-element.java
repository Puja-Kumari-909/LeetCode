class Solution {
    
    // Sliding Window with a bit of maths. Try to find the formula to get the valid window
    
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        long sum = 0;
        int left = 0;
        int ans = 0;
        
        for(int right=0; right<nums.length; right++){
            
            sum += nums[right];
            
            while((nums[right]*(right-left+1)) > (k + sum)){
                sum -= nums[left];
                left++;
            }
            
            ans = Math.max(ans, right-left+1);
        }
        
        return ans;
    }
}