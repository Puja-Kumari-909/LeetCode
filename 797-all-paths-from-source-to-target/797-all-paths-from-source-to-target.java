class Solution {
    
    // dont need visited cz the graph is DAG(acyclic)
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(list));
        
        while(!q.isEmpty()){
            
            ArrayList<Integer> temp = q.poll();
            
            if(temp.get(temp.size()-1) == graph.length-1)
                ans.add(new ArrayList<>(temp));
            
            else{
                for(int child : graph[temp.get(temp.size() - 1)]){
                    temp.add(child);
                    q.add(new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                }
            }
        }
        
        return ans;
    }
}