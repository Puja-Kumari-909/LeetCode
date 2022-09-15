class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        Arrays.sort(nums);
        
        // fix one number then left with two sum problem
        for(int i=0; i<nums.length-2; i++){
            
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                
                int target = 0 - nums[i];

                int l = i+1;
                int r = nums.length-1;

                while(l<r){

                    if(nums[l] + nums[r] == target){
                        
                        temp.add(nums[i]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);

                        ans.add(new ArrayList<>(temp));

                        temp.clear();
                    
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }

                    else if(nums[l] + nums[r] > target){
                        r--;
                    }
                    else
                        l++;
                }
            }
        }
        return ans;
    }
}