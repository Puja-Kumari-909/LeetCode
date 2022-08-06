class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) return mid;
                
            if(nums[low]<=nums[mid]){         // left side sorted
                
                if(nums[low]<=target && target<nums[mid]){        //if ele exist on left reduce the search space to left
                    high = mid - 1;
                }
                else{
                    low = mid + 1;                          // else try to search on right side
                }
            }
            else{                          // if left side is not sorted means the right side is sorted
                if(target>nums[mid] && target<=nums[high]){         //ele exist on right side sorted part
                    low = mid + 1;                              //reduce search space to right side
                }
                else{
                    high = mid - 1;                 //else search in the left portion
                }
            }
        }
        return -1;
    }
}