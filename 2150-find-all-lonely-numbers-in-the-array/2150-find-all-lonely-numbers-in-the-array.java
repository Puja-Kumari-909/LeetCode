class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        Map<Integer, Integer> fmap = new HashMap<>();
        
        for(int num : nums)
            fmap.put(num, fmap.getOrDefault(num, 0)+1);
        
        for(int num : nums)
            if(!fmap.containsKey(num-1) && !fmap.containsKey(num+1) && fmap.get(num)==1)
                ans.add(num);
        
        return ans;
    }
}