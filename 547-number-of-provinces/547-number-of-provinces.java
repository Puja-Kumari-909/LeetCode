class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected[0].length;
        
        int ans = 0;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
    
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(isConnected[i-1][j-1] == 1 && i != j)
                    adj.get(i).add(j);
            }
        }
        
        boolean[] vis = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            if(!vis[i]){
                System.out.println(i);
                connectedComponent(i, adj, vis);
                
                ans++;
            }
        }
        
        return ans;
    }
    
    private void connectedComponent(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        if(vis[node]) return;
        
        vis[node] = true;
        
        for(int adjNode : adj.get(node)){
            System.out.println(adjNode);
            connectedComponent(adjNode, adj, vis);
        }
    }
}