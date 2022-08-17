class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int num : nums1){
            set1.add(num);
        }
        
        for(int num : nums2){
            set2.add(num);
        }

        int[] ans = new int[set1.size()];
        
        int ind = 0;
        for(Integer s : set1){
            if(set2.contains(s)){
                ans[ind++] = s;
            }
        }
        
        return Arrays.copyOf(ans, ind);
    }
}