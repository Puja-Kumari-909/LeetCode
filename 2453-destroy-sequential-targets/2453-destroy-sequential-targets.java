class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int rem = nums[i] % space;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        int maxFreq = Collections.max(map.values());
        
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int rem = nums[i] % space;
            
            if(maxFreq == map.get(rem))
                return nums[i];
        }
        
        return 0;
    }
}