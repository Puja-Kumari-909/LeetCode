class Solution {
    
    // TC -- O(n*k)
    // SC -- O(n)
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        
        for(String str : strs){
            
            HashMap<Character, Integer> fmap = new HashMap<>();
            
            for(int i=0; i<str.length(); i++)
                fmap.put(str.charAt(i), fmap.getOrDefault(str.charAt(i), 0)+1);
            
            if(map.containsKey(fmap)){
                ArrayList<String> currList = map.get(fmap);
                currList.add(str);
            }
            else{
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(fmap, newList);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(ArrayList<String> itr : map.values())
            ans.add(itr);
        
        return ans;
    }
}