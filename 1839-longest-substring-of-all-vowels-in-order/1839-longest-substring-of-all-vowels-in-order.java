class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int res = 0;
        int currLength = 0;
        int vowelCount = 0;
        
        for(int i=0; i<word.length(); i++){
            if(i!=0 && word.charAt(i) < word.charAt(i-1)){
                vowelCount = 0;
                currLength = 0;
            }
            
            currLength++;
            if(i==0 || word.charAt(i) != word.charAt(i-1))
                vowelCount++;
            
            if(vowelCount == 5)
                res = Math.max(res, currLength);
        }
        return res;
    }
}