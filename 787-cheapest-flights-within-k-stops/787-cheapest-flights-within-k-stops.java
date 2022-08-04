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
        
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src, 0));
        int level = 0;
        
        while(!q.isEmpty() && level<=k){
            int size = q.size();
            
            while(size-- > 0){
                Pair temp = q.poll();
                int node = temp.node;
                int cost = temp.weight;
                
                for(Pair adjNode : adj.get(node)){
                    int adjNodeValue = adjNode.node;
                    int adjNodePrice = adjNode.weight;
                    
                    if(cost + adjNodePrice < price[adjNodeValue]){
                        price[adjNodeValue] = cost + adjNodePrice;
                        q.add(new Pair(adjNodeValue, cost + adjNodePrice));
                    }
                }
            }
            level++;
        }
        
        int cheapestPrice = -1;
        
        for(int i=0; i<price.length; i++){
            if(i==dst && price[i] != Integer.MAX_VALUE){
                cheapestPrice = price[i];
            }
        }
        
        return cheapestPrice;
    }
}