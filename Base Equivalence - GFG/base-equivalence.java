//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    String baseEquiv(int n, int m)
    {
        int low = 2;
        int high = 32;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(getDigits(n, mid) == m)
                return "Yes";
                
            if(getDigits(n, mid) < m)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return "No";
    }
    
    int getDigits(int n, int base){
        int count = 0;
        
        while(n != 0){
            count++;
            n = n/base;
        }
        
        return count;
    }
}