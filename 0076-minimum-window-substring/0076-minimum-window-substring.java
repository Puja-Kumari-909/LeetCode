class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        
        if(s.length() == 0 || s.length() < t.length())
            return ans;
        
        int minWindowLength = Integer.MAX_VALUE;
        
        int need = t.length();
        int have = 0;
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(Character ch : t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }
        
        int left = 0;
        
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            
            // if we got a useful character increment have
            if(tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch))
                have++;
            
            //if have is equals to the need, means we got a substring in s having all the character of t
            while(have == need){
                //check if its the minimum substring till now
                
                if(minWindowLength > right - left + 1){
                    minWindowLength = right-left+1;
                    ans = s.substring(left, right+1);
                }
                
                //now we will check, can we do better
				//is there a shorter substring
                
                char charToRemove = s.charAt(left);
                
                if(sMap.get(charToRemove) == 1)
                    sMap.remove(charToRemove);
                else
                    sMap.put(charToRemove, sMap.get(charToRemove) - 1);
                
                left++;
                
                //if we remove a useful char, decrementing have varaible
                if(tMap.containsKey(charToRemove) && sMap.getOrDefault(charToRemove,0)<(tMap.get(charToRemove))){
                    have--;
                }
            }
        }
        return ans;
    }
}