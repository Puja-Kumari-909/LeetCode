class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> fmap = new HashMap<>();
        
        for(int num : arr){
            fmap.put(num, fmap.getOrDefault(num, 0)+1);
        }
        
        Set<Integer> uniqueFreq = new HashSet<>();
        
        for(Map.Entry<Integer, Integer> ent : fmap.entrySet()){
            int val = ent.getValue();
            
            if(!uniqueFreq.add(val)){
                return false;
            }
        }
        
        return true;
    }
}