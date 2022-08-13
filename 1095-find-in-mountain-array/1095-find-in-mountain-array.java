/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();
        int low = 0;
        int high = n-1;
        int peakIndex = 0;
        
        //find peak index
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            int eleMid = arr.get(mid);
            int nextToMid = arr.get(mid+1);
            
            if((mid-1 >= 0 && eleMid>arr.get(mid-1)) && (mid+1<n && eleMid>nextToMid)){
                peakIndex = mid;
                break;
            }
            
            if(eleMid<nextToMid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        System.out.println(peakIndex);
        
        // search in the first half. 
        
        low = 0;
        high = peakIndex;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            int eleMid = arr.get(mid);
            
            if(target==eleMid)
                return mid;
            
            if(target < eleMid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        // if not found then search in the second half
        
        low = peakIndex;
        high = n-1;
        System.out.println("second half " + high);

        while(low<=high){
            int mid = low + (high - low)/2;
            System.out.println("second half mid " + mid);

            int eleMid = arr.get(mid);
            
            if(target==eleMid)
                return mid;
            
            if(target > eleMid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
    }
}