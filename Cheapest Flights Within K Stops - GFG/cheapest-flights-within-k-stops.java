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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair{
        int node;
        int distance;
        
        Pair(int n, int d){
            node = n;
            distance = d;
        }
    }
    
    class Tuple{
        int first;
        int second;
        int third;
        
        Tuple(int f, int s, int t){
            first = f;
            second = s;
            third = t;
        }
    }
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
       
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, 1000000007);
        
        Queue<Tuple> q = new LinkedList<>();
        
        q.add(new Tuple(0, src, 0));
        dist[src] = 0;
        
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int stops = curr.first;
            int node = curr.second;
            int curr_cost = curr.third;
            
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int cost = it.distance;
                
                if(cost + curr_cost < dist[adjNode] && stops<=k){
                    dist[adjNode] = cost + curr_cost;
                    q.add(new Tuple(stops+1, adjNode, cost + curr_cost));
                }
            }
        }
        
        if(dist[dst] == 1000000007)
            return -1;
            
        return dist[dst];
    }
}