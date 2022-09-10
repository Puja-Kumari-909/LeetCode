class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[][][] dp = new int[prices.length+1][2][k+1];
        
        for(int[][] arr : dp){
            for(int[] ar : arr){
                Arrays.fill(ar, -1);
            }
        }
        
        return helper(0, k, 1, prices, dp);
    }
    
    public int helper( int ind, int transactions, int buy, int[] arr, int[][][] dp){
        
        if(ind == arr.length || transactions == 0){
            return 0;
        }
        
        if(dp[ind][buy][transactions] != -1){
            return dp[ind][buy][transactions];
        }
        
        
        if(buy == 1){
            return dp[ind][buy][transactions] = Math.max((-arr[ind] + helper(ind+1, transactions, 0, arr, dp)) , (0 + helper(ind+1, transactions, 1, arr, dp)));
        }
        else
        return dp[ind][buy][transactions] = Math.max((arr[ind] + helper(ind+1, transactions-1, 1, arr, dp)) , (0 + helper(ind+1, transactions, 0, arr, dp)));
                              
    }
}