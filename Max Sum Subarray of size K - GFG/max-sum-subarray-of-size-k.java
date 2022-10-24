//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        
        long ans = 0;
        
        int left = 0;
        int right = 0;
        
        long currSum = 0;
        
        while(right<Arr.size()){
            
            currSum += Arr.get(right);
            
            if(right-left+1 < k)
                right++;
            else if(right-left+1 == k){
                ans = Math.max(ans, currSum);
                currSum -= Arr.get(left);
                left++;
                right++;
            }
        }
        
        return ans;
    }
}