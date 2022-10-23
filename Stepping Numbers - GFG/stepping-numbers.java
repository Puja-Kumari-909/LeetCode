//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int count = 0;
    
    int steppingNumbers(int n, int m){
        
        if(n == 0) count++;
        
        for(int i=1; i<=9; i++)
            helper(i, n, m);
            
        return count;
    }
    
    void helper(int currVal, int low, int high){
        if(currVal > high)
            return;
            
        if(currVal >= low && currVal <=high)
            count++;
            
        int lastDigit = currVal % 10;
        
        if(lastDigit != 0)
            helper(currVal*10 + (lastDigit-1), low, high);
        
        if(lastDigit != 9)
            helper(currVal*10 + (lastDigit + 1), low, high);
    }
}
