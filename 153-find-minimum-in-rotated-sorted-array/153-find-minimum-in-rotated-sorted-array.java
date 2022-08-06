class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            
            int mid = low + (high - low) / 2;
            
            if(mid>0 && nums[mid-1]>nums[mid])
                return nums[mid];
            
            if(nums[low]>nums[mid]){
                high = mid - 1;
            }
            else if(nums[high]<nums[mid]){
                low = mid + 1;
            }
            else{
                return nums[low];
            }
        }
        return -1;
    }
}