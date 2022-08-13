class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        // there is always going to be one part where the array is sorted, either right or left
        // after we find out which part is sorted we can easily find if target exist in that part or not
        // if it exist then we go to that half otherwise we go to the other half
        
        while(low<=high){
            
            int mid = low + (high - low)/2;
            
            if(nums[mid]==target) return mid;
            
            if(nums[low]<=nums[mid]){       // left is sorted
                if(target<nums[mid] && target>=nums[low]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{                           // right is sorted
                if(target>nums[mid] && target<=nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}