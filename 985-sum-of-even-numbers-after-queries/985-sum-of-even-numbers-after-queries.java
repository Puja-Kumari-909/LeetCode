class Solution {
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] ans = new int[nums.length];
        
        int sum = 0;
        
        for(int num : nums)
            if(num%2 == 0)
                sum += num;
        
        int idx = 0;
        
        for(int[] q : queries){
            
            int index = q[1];
            int val = q[0];
            
            if(nums[index] % 2 == 0)
                sum -= nums[index];
            
            nums[index] += val;
            
            if(nums[index] % 2 == 0)
                sum += nums[index];
            
            ans[idx++] = sum;
        }
        
        return ans;
    }
}