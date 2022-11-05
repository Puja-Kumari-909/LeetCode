//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int arr[] = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxGroupSize(int[] arr, int N, int K) {
        
        int[] freq = new int[K];
        
        for(int i=0; i<N; i++)
            freq[arr[i]%K]++;
            
        int ans = 0;
        
        for(int i=0; i<=K/2; i++){
            if(i==0 || i == (K-i)){
                if(freq[i] > 0)
                    ans++;
            }
            else
                ans += Math.max(freq[i], freq[K-i]);
        }
        
        return ans;
    }
};