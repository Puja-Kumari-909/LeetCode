//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair{
        int node, distance;
        
        Pair(int n, int d){
            node = n;
            distance = d;
        }
    }
    
    public int[] shortestPath(int[][] edges,int v,int n ,int src) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<v; i++)
            adj.add(new ArrayList<Integer>());
            
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] dist = new int[v];
        
        Arrays.fill(dist, 1000000007);
        dist[src] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src, 0));
       
        
        while(!q.isEmpty()){
            Pair currNode = q.poll();
            
            for(int adjNode : adj.get(currNode.node)){
                if(dist[adjNode]>currNode.distance+1){
                    dist[adjNode] = currNode.distance+1;
                    q.add(new Pair(adjNode, currNode.distance+1));
                }
            }
    
        }
        
        for(int i=0; i<v; i++){
            if(dist[i]==1000000007)
                dist[i] = -1;
        }
        
        return dist;
    }
}