class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] pMap = new int[26];
        int[] sMap = new int[26];
        
        for(int i=0; i<p.length(); i++)
            pMap[p.charAt(i) - 'a']++;
        
        int left = 0;
        int right = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        while(right<s.length()){
            
            sMap[s.charAt(right)-'a']++;
            
            if(right-left+1 < p.length())
                right++;
            
            else if(right-left+1 == p.length()){
                
                if(isAnagram(sMap, pMap))
                    ans.add(left);
                
                sMap[s.charAt(left) - 'a']--;
                
                left++;
                right++;
            }
        }
        
        return ans;
    }
    
    private boolean isAnagram(int[] m1, int[] m2){
        
        for(int i=0; i<26; i++)
            if(m1[i]!=m2[i])
                return false;
        
        return true;
    }
}