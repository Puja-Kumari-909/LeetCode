class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int count = 0;
        boolean central = false;
        
        for(Map.Entry<String, Integer> ent : map.entrySet()){
            String word = ent.getKey();
            int freq = ent.getValue();
            
            // if the word is palindrome
            if(word.charAt(0) == word.charAt(1)){
                if (freq % 2 == 0) {
                    count += freq;
                } else {
                    count += freq - 1;
                    central = true;
                }
            }
             else if (word.charAt(0) < word.charAt(1)){     // to avoid duplicacy we only consider the word once when its in sorted form
                String reverse = "" + word.charAt(1) + word.charAt(0);
                if(map.containsKey(reverse)){
                    count += 2 * (Math.min(freq, map.get(reverse)));
                }
            }
        }
        
         if (central) {
            count++;
        }
        
        return count * 2;
    }
}