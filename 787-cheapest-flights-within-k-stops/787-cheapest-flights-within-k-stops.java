class Solution {
    
    class Pair{
        int node;
        int weight;
        
        Pair(int n, int w){
            node = n;
            weight = w;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<Pair>> adj = new HashMap<>();
        
        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<Pair>());
        }
        
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dis[src] = 0;
        
        int level = 0;
        
        while(!q.isEmpty() && level<k+1){
            int size = q.size();
            
            while(size-- > 0){
                Pair currPair = q.poll();
                int node = currPair.node;
                int weight = currPair.weight;
                
                for(Pair adjNode : adj.get(node)){
                    if(weight + adjNode.weight < dis[adjNode.node]){
                        dis[adjNode.node] = weight + adjNode.weight;
                        q.add(new Pair(adjNode.node,dis[adjNode.node]));
                    }
                }
            }
            level++;
        }
        
        int cheapestPrice = 0;
        
        for(int i=0; i<dis.length; i++){
            if(i == dst && dis[i] != Integer.MAX_VALUE){
                return dis[i];
            }
        }
        
        return -1;
    }
}