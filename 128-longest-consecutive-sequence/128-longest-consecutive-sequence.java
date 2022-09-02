class Solution {
    
    // Take a map and mark all numbers as true. True means this is the start of the sequence
    // Try looking for consecutive prev ele of the curr ele in map. If exist then make entry as false
    // bcz its clearly not the start of the sequence and keep doing it until some elems are left true
    // now try finding the longest sequence which can be built with each ele and track the max
    
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        Map<Integer, Boolean> hmap = new HashMap<>();
        
        for(int num : nums){
            hmap.put(num, true);
        }
        
        for(int i=0; i<nums.length; i++){
            if(hmap.containsKey(nums[i] - 1)){
                hmap.put(nums[i], false);
            }
        }
        
        int max = 1;
        
        for(int i=0; i<nums.length; i++){
            
            if(hmap.get(nums[i]) == true){
                
                int len = 1;
                
                while(hmap.containsKey(nums[i] + len)){
                    len++;
                }
                
                max = Math.max(max, len);
            }
        }
        
        return max;
    }
}