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
    
    // Reverse the links and backtrack from the terminal nodes to all the nodes using topo sort

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<List<Integer>> adjRev = new ArrayList<>();
        
        int[] inDeg = new int[V];
        
        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                adjRev.get(it).add(i);
                inDeg[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(inDeg[i]==0)
                q.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            ans.add(curr);
            
            for(int adjNode : adjRev.get(curr)){
                if(--inDeg[adjNode]==0)
                    q.add(adjNode);
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}
