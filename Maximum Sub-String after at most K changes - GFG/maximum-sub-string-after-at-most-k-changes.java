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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        int n = s.length();
        int i = 0;
        int ans = 0;
        int maxFreq = 0;
        
        char[] str = s.toCharArray();
        char[] freq = new char[26];
        
        for(int j=0; j<n; j++){
            freq[str[j]-'A']++;
            maxFreq = Math.max(maxFreq, freq[str[j]-'A']);
            
            while(j-i+1 - maxFreq > k){
                freq[str[i]-'A']--;
                i++;
            }
            
            ans = Math.max(ans, j-i+1);
        }
        
        return ans;
    }
}