class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        
        List<String> temp = new ArrayList<>();
        helper(0, s, temp, ans);
        
        return ans;
    }
    
    private void helper(int ind, String s, List<String> temp, List<List<String>> ans){
        
        if(ind == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                temp.add(s.substring(ind, i+1));
                helper(i+1, s, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int i, int j){
        
        if(s.length()==0) return false;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}
