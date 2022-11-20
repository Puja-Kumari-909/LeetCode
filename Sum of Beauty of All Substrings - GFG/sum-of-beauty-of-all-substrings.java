//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        
        int ans = 0;
        
        int n = s.length();
        
        for(int i=0; i<n; i++){
            
            int[] freq = new int[26];
            Arrays.fill(freq, -1);
            for(int j=i; j<n; j++){
                
                freq[s.charAt(j)-'a']++;
                
                int max = getMax(freq);
                int min = getMin(freq);
                
                // System.out.println(max+ " "+ min);
                
                int beauty = max - min;
                // System.out.println("beauty "+ beauty);
                
                ans += beauty;
            }
        }
        
        return ans;
    }
    
    static int getMax(int[] freq){
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<freq.length; i++){
            if(freq[i] != -1)
                max = Math.max(max, freq[i]);
        }
        
        return max;
    }
    
    static int getMin(int[] freq){
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<freq.length; i++){
            if(freq[i] != -1)
                min = Math.min(min, freq[i]);
        }
        
        return min;
    }
}