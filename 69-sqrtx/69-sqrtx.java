class Solution {
    public int mySqrt(int x) {
        
        if(x == 1) return 1;
        
        int low = 1;
        int high = x/2;
        
        int ans = 0;
        
        while(low<=high){
            
            int mid = low + (high - low) / 2;
            
            if((long) mid*mid < x){
                ans = mid;
                low = mid + 1;
            }
            else if((long) mid*mid > x){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        
        return ans;
    }
}