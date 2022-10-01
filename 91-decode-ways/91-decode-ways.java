class Solution {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length()];
        
        Arrays.fill(dp, -1);
        
        return helper(0, s, dp);
    }
    
    private int helper(int ind, String s, int[] dp){
        
        if(ind == s.length())
            return 1;
        
        if(s.charAt(ind) == '0')
            return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int takeOne = helper(ind+1, s, dp);
        
        int takeTwo = 0;
        
        if(ind<s.length()-1 && (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind+1) < '7')))
            takeTwo = helper(ind+2, s, dp);
        
        return dp[ind] = takeOne + takeTwo;
    }
}
