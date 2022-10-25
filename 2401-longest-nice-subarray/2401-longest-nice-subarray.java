class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        long num = 0;
        int ans = 0;
        int left = 0;
        
        for(int right=0; right<nums.length; right++)
        {
            while((num & nums[right]) != 0)
            {
                num ^= nums[left];
                left++;
            }
            
            num |= nums[right];
            ans = Math.max(ans, right-left+1);
        }
        
        return ans;
    }
}

