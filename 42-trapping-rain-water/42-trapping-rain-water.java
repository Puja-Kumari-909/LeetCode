class Solution {
    public int trap(int[] height) {

        int n = height.length;
        
        if(n==1) return 0;
        
        int ans = 0;
        
        int l = 0;
        int r = n-1;
        int leftMax = 0;
        int rightMax = 0;
        
        while(l<=r){
            
            // we know that there is something bigger on the right already so we can safily compute the left storage
            if(height[l]<=height[r]){         
                
                if(height[l]>=leftMax){
                    leftMax = height[l];
                }
                else{
                    ans += leftMax - height[l];
                }
                l++;
            }
            
            // otherwise we know that something bigger is there on left so we then compute the right storage
            else{
                
                if(height[r] >= rightMax){
                    rightMax = height[r];
                }
                else{
                    ans += rightMax - height[r];
                }
                r--;
            }
        }
        
        return ans;
    }
}