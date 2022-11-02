//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    class Pair{
        int node;
        int parent;
        
        Pair(int n, int p){
            node = n;
            parent = p;
        }
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V+1];
        
        for(int i=0; i<V; i++){
            if(!vis[i] && checkCycle(i, adj, vis))
                return true;
        }
        
        return false;
    }
    
    boolean checkCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        vis[src] = true;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src, -1));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int currNode = temp.node;
            int parent = temp.parent;
            
            for(int adjNode : adj.get(currNode)){
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, currNode));
                }
                else if(adjNode != parent){
                    return true;
                }
            }
        }
        
        return false;
    }
}