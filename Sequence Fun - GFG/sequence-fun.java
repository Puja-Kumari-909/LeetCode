//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int NthTerm(int n)
    {
        long[] arr = new long[n+1];
        arr[1] = 2;
        
        for(int i=2; i<=n; i++){
            arr[i] = (arr[i-1] * i + 1) % 1000000007;
        }
        
        return (int)(arr[n]%1000000007);
    }
}