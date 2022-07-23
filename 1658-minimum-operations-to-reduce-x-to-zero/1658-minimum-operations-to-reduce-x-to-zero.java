class Solution {
    
    // problem is similar to finding maximum subarray which has a sum of total array sum - x
    // use prefix sum to calculate the subarray with the desired sum and also keep
    // updating the number of ele if found better ans
    // lastly return total ele in the array - this subarray elements
    
    public int minOperations(int[] nums, int x) {
        
        int target = 0;
        int totalSum = 0;
        
        for(int num : nums){
            totalSum += num;
        }
        
        target = totalSum - x;
        
        if(target == 0) return nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        int res = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            
            sum += nums[i];
            
            if(map.containsKey(sum - target)){
                res = Math.max(res, i - map.get(sum - target));
            }
            
            map.put(sum, i);
        }
        
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}