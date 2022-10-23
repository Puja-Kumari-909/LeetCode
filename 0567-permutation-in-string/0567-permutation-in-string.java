class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length() < s1.length()) return false;
        
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        for(char ch : s1.toCharArray()){
            s1map[ch - 'a']++;
        } 
        
        int left = 0;
        int right = 0;
        
        while(right < s2.length()){
            
            s2map[s2.charAt(right) - 'a']++;
            
            if(right-left+1 == s1.length())
                if(isMatched(s1map, s2map))
                    return true;
            
            if(right-left+1 < s1.length())
                right++;
            else{
                s2map[s2.charAt(left) - 'a']--;
                left++;
                right++;
            }
        }
        
        return false;
    }
    
    public boolean isMatched(int[] m1, int[] m2){
        
        for(int i=0; i<m1.length; i++){
            if(m1[i]!=m2[i])
                return false;
        }
        return true;
    }
}