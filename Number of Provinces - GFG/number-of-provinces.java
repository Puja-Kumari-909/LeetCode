//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    public int findParent(int node){
        if(node == parent.get(node))
            return node;
            
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }
        else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else{
            parent.set(ulp_v, ulp_u);
            int rank_u = rank.get(ulp_u);
            rank.set(ulp_u, rank_u + 1);
        }
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j)==1){
                    ds.unionByRank(i, j);
                }
            }
        }
        
        int count = 0;
        
        for(int i=0; i<V; i++){
            if(ds.findParent(i) == i){
                count++;
            }
        }
        return count;
    }
};