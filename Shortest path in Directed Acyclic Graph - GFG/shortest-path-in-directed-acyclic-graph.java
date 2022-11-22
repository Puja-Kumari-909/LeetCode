//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    class Pair{
        int node, weight;
        
        Pair(int n, int w){
            node = n;
            weight = w;
        }
    }

	public int[] shortestPath(int V, int N, int[][] edges) {
		
		List<List<Pair>> adj = new ArrayList<>();
		
		for(int i=0; i<V; i++)
		    adj.add(new ArrayList<Pair>());
		    
		for(int[] edge : edges){
		    int currNode = edge[0];
		    int adjNode = edge[1];
		    int weight = edge[2];
		    
		    adj.get(currNode).add(new Pair(adjNode, weight));
		}
		
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++)
		    if(!visited[i])
	    	    topoSort(i, adj, st, visited);
	    
	    int[] dist = new int[V];
	    Arrays.fill(dist, 100000007);
	    dist[0] = 0;
	    int currentWeight = 0;
	    
	    while(!st.isEmpty()){
	        int curr = st.pop();
	        
	        for(Pair it : adj.get(curr)){
	            int value = it.node;
	            int wt = it.weight;
	            
	            if(dist[curr]+wt < dist[value]){
	                dist[value] = dist[curr]+wt;
	            }
	        }
	    }
	    
	    for(int i=0; i<V; i++){
	        if(dist[i]== 100000007)
	            dist[i] = -1;
	    }
	    
	    return dist;
	}
	
	private void topoSort(int currNode, List<List<Pair>> adj, Stack<Integer> st, boolean[] vis){
	    vis[currNode] = true;
	    
	    for(Pair adjNode : adj.get(currNode)){
	        if(!vis[adjNode.node]){
	            topoSort(adjNode.node, adj, st, vis);
	        }
	    }
	    
	    st.push(currNode);
	}
}