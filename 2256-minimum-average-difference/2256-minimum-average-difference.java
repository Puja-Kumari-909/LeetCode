class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        
        long[] left = new long[n+1];
        
        long[] right = new long[n+1];
        
        for(int i=0; i<n; ++i){
            left[i+1] = left[i]+nums[i];
        }
        
        for(int i=n-1; i>=0; --i){
            right[i] = right[i+1]+nums[i];
        }
        
        int minInd = -1;
        long minAvgDiff = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            long leftPartAverage = left[i + 1];
            leftPartAverage /= (i + 1);
            
            long rightPartAverage = right[i + 1];

            if (i != n - 1) {
                rightPartAverage /= (n - i - 1);
            }
            
            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);

            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                minInd = i;
            }
        }
        
        return minInd;
    }
}
