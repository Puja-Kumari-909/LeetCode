class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        
        helper(0, nums, temp, ans);
        
        return ans;
    }
    
    private void helper(int ind, int[] nums, List<Integer> temp, List<List<Integer>> ans){
        if(ind==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        helper(ind+1, nums, temp, ans);
        
        temp.add(nums[ind]);
        helper(ind+1, nums, temp, ans);
        temp.remove(temp.size()-1);
    }
}