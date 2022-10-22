//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 int t=sc.nextInt();
    	 while(t-->0)
    	 {
    	        int n = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++)
    		    {
    		        arr[i] = sc.nextInt();
    		    }
    		    int sum = sc.nextInt();
    		    System.out.println(new Solution().subArraySum(arr, n, sum));
    		    
    		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int n, int sum)
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        int count = 0;
        int currSum = 0;
        
        for(int i=0; i<n; i++){
            
            currSum += arr[i];
            
            if(map.containsKey(currSum - sum)){
                count += map.get(currSum - sum);
            }
               
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}