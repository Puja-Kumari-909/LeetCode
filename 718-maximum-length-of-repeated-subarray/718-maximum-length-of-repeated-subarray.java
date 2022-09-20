class Solution {
    
    // Similar to finding common substring problem
    public int findLength(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; i++){
            dp[i][0] = 0;
        }
        
        for(int j=0; j<=n2; j++){
            dp[0][j] = 0;
        }
        
        int max = 0;
        
        for(int i=1; i<=n1; i++){
            
            for(int j=1; j<=n2; j++){
                
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        
        return max;
    }
}