class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjlist = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjlist.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] vis = new boolean[n];
        
        q.add(source);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int currNode = q.poll();
                vis[currNode] = true;
                if(currNode == destination){
                    return true;
                }
                
                for(int adjNode : adjlist.get(currNode)){
                    if(!vis[adjNode])
                        q.add(adjNode);
                }
            }
        }
        
        return false;
    }
}