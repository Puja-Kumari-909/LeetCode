class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> hmap = new HashMap<>();
        
        for(char c : s.toCharArray()){
            if(hmap.containsKey(c)){
                hmap.put(c, hmap.get(c)+1);
            }
            else{
                hmap.put(c, 1);
            }
        }
        
        for(char c : t.toCharArray()){
            if(!hmap.containsKey(c)){
                return false;
            }
            else{
                int val = hmap.get(c);
                if(val == 1){
                    hmap.remove(c);
                }
                else
                    hmap.put(c, val-1);            
            }
        }
        
        if(hmap.isEmpty())
            return true;
        else
            return false;
    }
}