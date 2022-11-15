//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
            adj.add(new ArrayList<>());
            
        for(int[] pre : prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        
        int[] inDegree = new int[N];
        
        for(int i=0; i<N; i++){
            for(int adjNode : adj.get(i))
                inDegree[adjNode]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int currEle = q.poll();
            count++;
            
            for(int adjEle : adj.get(currEle)){
                inDegree[adjEle]--;
                if(inDegree[adjEle]==0)
                    q.add(adjEle);
            }
        }
        
        if(count==N) return true;
        
        return false;
    }
    
}