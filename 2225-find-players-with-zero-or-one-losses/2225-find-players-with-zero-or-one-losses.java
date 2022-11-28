class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        Set<Integer> winner = new HashSet<>();
        Map<Integer, Integer> loser = new HashMap<>();
        
        for(int[] m : matches){
            winner.add(m[0]);
            loser.put(m[1], loser.getOrDefault(m[1], 0)+1);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> win = new ArrayList<>();
        
        for(int it : winner){
            if(!loser.containsKey(it)){
                win.add(it);
            }
        }
        
        ArrayList<Integer> lose = new ArrayList<>();

        for(Map.Entry<Integer, Integer> ent : loser.entrySet()){
            int key = ent.getKey();
            int val = ent.getValue();
            
            if(val == 1){
                lose.add(key);
            }
        }
        
        Collections.sort(win);
        Collections.sort(lose);
        
        ans.add(win);
        ans.add(lose);
        
        return ans;
    }
}