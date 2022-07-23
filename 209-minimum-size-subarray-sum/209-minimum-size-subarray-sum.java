class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left_ind = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
    
        for(int i=0; i<nums.length; i++){
            
            sum += nums[i];
            
            while(sum >= target){
                res = Math.min(res, i - left_ind + 1);
                sum -= nums[left_ind];
                left_ind++;
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}