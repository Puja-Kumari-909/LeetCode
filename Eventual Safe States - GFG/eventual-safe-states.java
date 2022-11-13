//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        int[] check = new int[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i])
                dfs(i, vis, pathVis, check, adj);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(check[i]==1)
                ans.add(i);
        }
        
        return ans;
    }
    
    boolean dfs(int currNode, boolean[] vis, boolean[] pathVis, int[] check,List<List<Integer>> adj){
        vis[currNode] = true;
        pathVis[currNode] = true;
        check[currNode] = 0;
        for(int adjNode : adj.get(currNode)){
            if(!vis[adjNode]){
                if(dfs(adjNode, vis, pathVis, check, adj)){
                    check[adjNode] = 0;
                    return true;
                }
            }
            else if(pathVis[adjNode]){
                check[adjNode] = 0;
                return true;
            }
        }
        
        check[currNode] = 1;
        pathVis[currNode] = false;
        return false;
    }
}
