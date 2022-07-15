class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int l = 0;
        int r = nums.length-1;
        
        //find left position
        while(l<=r){
            
            int mid = l + (r-l) /2;
            
            if(nums[mid]>target){
                r = mid-1;
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                ans[0] = mid;
                r = mid - 1;
            }
        }
        
        l=0;
        r=nums.length-1;
        
        //find right position
        while(l<=r){
            
            int mid = l + (r-l) / 2;
            
            if(nums[mid]>target){
                r = mid-1;
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                ans[1] = mid;
                l = mid+1;
            }
        }
        
        return ans;
    }
}