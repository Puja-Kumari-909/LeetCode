//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int MOD = 100000000;
    
    static int fillingBucket(int N) {
        
        int[] dp = new int[N+1];
        
        Arrays.fill(dp, -1);
        
        return helper(N, dp);
    }
    
    static int helper(int n, int[] dp){
        
        if(n<0) 
            return 0;
            
        if(n==0)
            return 1;
          
        if(dp[n] != -1)
            return dp[n];
            
        int pickOne = helper(n-1, dp);
        int pickTwo = helper(n-2, dp);
        
        return dp[n] = (pickOne+pickTwo) % MOD;
    }
};