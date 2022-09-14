class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> hmap = new HashMap<>();
        
        int[] ans = new int[2];
        
        for(int i=0; i<nums.length; i++){
            
            if(hmap.containsKey(target - nums[i])){
                ans[0] = hmap.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            
            hmap.put(nums[i], i);
        }
        
        return ans;
    }
}