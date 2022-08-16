class Solution {
    public char repeatedCharacter(String s) {
        
        Set<Character> hset = new HashSet<>();
        
        for(char c : s.toCharArray()){
            if(hset.contains(c))
                return c;
            
            hset.add(c);
        }
        return '_';
    }
}