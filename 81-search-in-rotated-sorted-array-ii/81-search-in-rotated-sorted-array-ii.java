class Solution {
    public boolean search(int[] nums, int target) {
        // the only problem here is that after rotation mid, high and low can be the same elements
        // and we wont be able to find out which side is sorted and apply the same logic of prev version of this problem
        // so until low high and mid are same we need to skip some elements from left and right end so that the
        // we can find out which part is sorted. After this we can simply apply normal Search in Rotated Sorted method
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            
            int mid = low + (high - low)/2;
            System.out.println(mid);
            
            if(nums[mid] == target) return true;
            
            // skip duplicates
            if((nums[low]==nums[mid]) && (nums[mid]==nums[high])){
                low++;
                high--;
            }
            
            // now apply simple logic of prev version of this problem
            
            else if(nums[low]<=nums[mid]){
                if((target>=nums[low]) && (target < nums[mid]))
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else{
                if((target<=nums[high]) && (target > nums[mid]))
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}