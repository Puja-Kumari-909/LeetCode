//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static class Pair{
        int node;
        int distance;
        
        public Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){

	    ArrayList<Pair>[] graph = new ArrayList[V];
	    boolean[] vis = new boolean[V];
	    int sum = 0;
	    
	    for(int i=0;i<V;i++){
	        graph[i] = new ArrayList<>();
	    }
        	    
	    for(int[] edge:edges){
	        int u = edge[0];
	        int v = edge[1];
	        int w = edge[2];
	        graph[u].add(new Pair(v,w));
	        graph[v].add(new Pair(u,w));
	    }
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
	        return a.distance-b.distance;
	    });
	    pq.add(new Pair(0,0));
	    
	    while(pq.size()!=0)
	    {
	        Pair rpair = pq.remove();
	        
	        if(vis[rpair.node]) continue;
	        vis[rpair.node] = true;
	        sum += rpair.distance;
	        
	        for(Pair pair:graph[rpair.node]){
	            if(!vis[pair.node]){
	                pq.add(pair);
	            }
	        }
	    }
	    return sum;
	}
}