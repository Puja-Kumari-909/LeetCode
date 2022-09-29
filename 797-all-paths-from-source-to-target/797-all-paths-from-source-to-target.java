class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        helper(graph, 0, temp, ans);
        
        return ans;
    }
    
    private void helper(int[][] graph, int node, ArrayList<Integer> temp,  List<List<Integer>> ans){
        
        if(node == graph.length - 1){
            temp.add(node);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        
        temp.add(node);
        
        for(int child : graph[node]){
            helper(graph, child, temp, ans);
        }
        
        temp.remove(temp.size() - 1);
    }
}