//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        
        int RCount = 0;
        int GCount = 0;
        int BCount = 0;
        
        for(String curr : a)
        {
            if(curr.equals("R"))
                RCount++;
            else if(curr.equals("G"))
                GCount++;
            else
                BCount++;
        }
        
        if(RCount!=0 && GCount==0 && BCount==0)
            return RCount;
        if(GCount!=0 && RCount==0 && BCount==0)
            return GCount;
        if(BCount!=0 && GCount==0 && RCount==0)
            return BCount;
            
        if((RCount%2==0 && GCount%2==0 && BCount%2==0) || (RCount%2!=0 && GCount%2!=0 && BCount%2!=0))
            return 2;
            
        else
            return 1;
    }
}