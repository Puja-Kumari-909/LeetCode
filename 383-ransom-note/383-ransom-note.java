class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> fmap = new HashMap<>();
        
        for(char c : ransomNote.toCharArray()){
            fmap.put(c, fmap.getOrDefault(c, 0) + 1);
        }
        
        for(char c : magazine.toCharArray()){
            
            if(fmap.containsKey(c)){
                
                fmap.put(c, fmap.get(c) - 1);
                
                if(fmap.get(c) == 0)
                    fmap.remove(c);
            }
            
            if(fmap.isEmpty())
                return true;
        }
        
        return false;
    }
}