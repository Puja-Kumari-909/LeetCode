class Solution {

    public int firstUniqChar(String s) {
        
        Map<Character, Integer> hmap = new HashMap<>();
        
        for(char c : s.toCharArray()){
            hmap.put(c, (hmap.getOrDefault(c, 0) + 1));
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(hmap.get(c) == 1)
                return i;
        }
        return -1;
    }
}