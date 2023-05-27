//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Solution
{
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=0, j=0, k=0;
        
        while(i<n1 && j<n2 && k<n3)
        {
            if(a[i] ==  b[j] && b[j] == c[k]){
                ans.add(a[i]);
                i++;
                j++;
                k++;
            }
            
            else if(a[i] < b[j]){
                i++;
            }
            else if(b[j] < c[k]){
                j++;
            }
            else{
                k++;
            }
            
            // handle duplicates
            
            int prev1=-1, prev2=-1, prev3=-1;
            
            if(i>0)
                prev1 = a[i-1];
            
            if(j>0)
                prev2 = b[j-1];
                
            if(k>0)
                prev3 = c[k-1];
                
            while(i<n1 && a[i]==prev1)
                i++;
            
            while(j<n2 && b[j] == prev2)
                j++;
                
            while(k<n3 && c[k] == prev3)
                k++;
        }
        
        if(ans.size() == 0) {
            ans.add(-1);
        }
        
        return ans;
    }
}