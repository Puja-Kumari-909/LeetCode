class Solution {
    
    class Pair{
        int node;
        int distance;
        
        public Pair(int n, int d){
            node = n;
            distance = d;
        }
    }
    
    public int networkDelayTime(int[][] edges, int n, int src) {
        
        // Create adj list
        
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
        
        dijkstraUsingPriorityQueue(adj, n, src, vis, distance); 
        
        int time = 0;
        
        for(int t : distance){
            if(t == Integer.MAX_VALUE)
                return -1;
            
            time = Math.max(time, t);
        }
        
        return time;
    }
    
    
    private void dijkstraUsingPriorityQueue(Map<Integer, List<Pair>> adj, int n, int source, boolean[] vis, int[] distance){
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        
        distance[source] = 0;
        pq.add(new Pair(source, 0));
        
        int visitedNodes = 0;
        
        while(!pq.isEmpty() && visitedNodes <= n){
            Pair pair = pq.poll();
            int currNode = pair.node;
            int dis = pair.distance;
            
            if(vis[currNode]) continue;
            vis[currNode] = true;
            visitedNodes++;
            
            for(Pair adjNode : adj.get(currNode)){
                if(dis + adjNode.distance < distance[adjNode.node]){   //relaxation
                    distance[adjNode.node] = dis + adjNode.distance;
                    pq.add(new Pair(adjNode.node, distance[adjNode.node]));
                }
            }
        }
    }
}