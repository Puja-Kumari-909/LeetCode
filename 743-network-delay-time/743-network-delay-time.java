class Solution {
    
    class Pair{
        int node;
        int distance;
        
        Pair(int n, int d){
            node = n;
            distance = d;
        }
    }
    
    public int networkDelayTime(int[][] edges, int n, int k) {
        
        Map<Integer, List<Pair>> adj = new HashMap<>();
        
        for(int i=0; i<=n; i++){
            adj.put(i, new ArrayList<Pair>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        
        int[] distance = new int[n+1];
        boolean[] vis = new boolean[n+1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = -1;
        
        dij(adj, n, k, vis, distance);
        
        int time = 0;
        
        for(int t : distance){
            if(t == Integer.MAX_VALUE)
                return -1;
            
            time = Math.max(time, t);
        }
        
        return time;
    }
    
    public void dij(Map<Integer, List<Pair>> adj, int n, int src, boolean[] vis, int[] distance){
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        
        distance[src] = 0;
        pq.add(new Pair(src, 0));
        
        int nodesProcessed = 0;
        
        while(!pq.isEmpty() && nodesProcessed<=n){
            Pair pair = pq.poll();
            int currNode = pair.node;
            int currDistance = pair.distance;
            
            if(vis[currNode]) continue;
            vis[currNode] = true;
            nodesProcessed++;
            
            for(Pair adjNode : adj.get(currNode)){
                if(currDistance + adjNode.distance < distance[adjNode.node]){
                    distance[adjNode.node] = currDistance + adjNode.distance;
                    pq.add(new Pair(adjNode.node, distance[adjNode.node]));
                }
            }
        }
    }
}