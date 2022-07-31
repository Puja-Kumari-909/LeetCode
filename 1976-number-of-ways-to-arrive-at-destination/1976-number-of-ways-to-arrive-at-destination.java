class Solution {
    
    class Pair{
        int node;
        int distance;
        
        Pair(int n, int d){
            node = n;
            distance = d;
        }
    }
    
    private int MOD = 1000000007;
    
    public int countPaths(int n, int[][] roads) {
        
        Map<Integer, List<Pair>> adj = new HashMap<>();
        
        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<Pair>());
        }
        
        for(int[] road : roads){
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        int[] ways = new int[n];
        
        dijkstra(distance, ways, n, 0, adj);
        return ways[n-1];
    }
    
    public void dijkstra(int[] distance, int[] ways, int n, int src, Map<Integer, List<Pair>> adj){
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        
        pq.add(new Pair(src, 0));
        distance[src] = 0;
        ways[src] = 1;
        
        while(!pq.isEmpty()){
            Pair currNode = pq.poll();
            int currData = currNode.node;
            int currDistance = currNode.distance;
            
            for(Pair adjNode : adj.get(currData)){
                int adjNodeData = adjNode.node;
                int adjNodeDistance = adjNode.distance;
                
                /* this means that we've found a better(less time consuming) 
				way to reach adjNode, now this better way will prevail and 
				we now don't care about past ways therefore total number 
				of ways to reach adjNode is simply equal to the total number of ways 
				to reach its parent which is currNode */
                
                if(currDistance + adjNodeDistance < distance[adjNodeData]){
                    distance[adjNodeData] = currDistance + adjNodeDistance;
                    ways[adjNodeData] = ways[currData];
                    pq.add(new Pair(adjNodeData, currDistance + adjNodeDistance));
                }
                
                /* here we have a way to reach adjNode which is taking same amount 
				of time	as the optimal path but this time parent of adjNode 
				is different therefore we ways to reach currNode to current ways 
				of reaching adjNode */
                
                else if(currDistance + adjNodeDistance == distance[adjNodeData]){
                    ways[adjNodeData] =  (ways[adjNodeData] + ways[currData]) % MOD;
                }
            }
        }
    }
}