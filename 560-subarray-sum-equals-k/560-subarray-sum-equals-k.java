class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> hmap = new HashMap<>();
        
        hmap.put(0, 1);
        
        int sum = 0;
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            if(hmap.containsKey(sum-k)){
                int val = hmap.get(sum-k);
                count += val;
            }
            
            hmap.put(sum, hmap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}