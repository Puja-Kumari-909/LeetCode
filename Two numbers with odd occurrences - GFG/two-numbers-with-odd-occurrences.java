//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int N)
    {
        int[] ans = new int[2];
        
        int ind = 0;
        
        Map<Integer, Integer> fmap = new HashMap<>();
        
        for(int num : arr)
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        
        for(Map.Entry<Integer, Integer> ent : fmap.entrySet()){
            int key = ent.getKey();
            int val = ent.getValue();
            
            if(val%2 != 0)
                ans[ind++] = key;
        }
        
        if(ans[0]<ans[1]){
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = temp;
        }
        
        return ans;
    }
}