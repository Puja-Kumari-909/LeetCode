class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
            adj.add(new ArrayList<>());
            
        for(int[] pre : prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        
        int[] inDegree = new int[N];
        
        for(int i=0; i<N; i++){
            for(int adjNode : adj.get(i))
                inDegree[adjNode]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int currEle = q.poll();
            count++;
            
            for(int adjEle : adj.get(currEle)){
                inDegree[adjEle]--;
                if(inDegree[adjEle]==0)
                    q.add(adjEle);
            }
        }
        
        if(count==N) return true;
        
        return false;
    }
}