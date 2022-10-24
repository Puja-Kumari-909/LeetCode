class Solution {
    
    // Pick notPick pattern
    public int maxLength(List<String> arr) {
        
        int[] ans = new int[1];
        
        helper(arr, 0, "", ans);
        
        return ans[0];
    }
    
    private void helper(List<String> arr, int ind, String currString, int[] ans){
        
        if(ind == arr.size() && isUnique(currString)){
            ans[0] = Math.max(ans[0], currString.length());
            return;
        }
        
        if(ind == arr.size())
            return;
        
        helper(arr, ind+1, currString, ans);
        helper(arr, ind+1, currString + arr.get(ind), ans);
    }
    
    private boolean isUnique(String str){
        
        int[] a = new int[26];
        
        for(char c : str.toCharArray()){
            if(a[c - 'a']>0)
                return false;
            else
                a[c-'a']++;
        }
        return true;
    }
}