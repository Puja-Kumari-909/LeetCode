class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        
        int[] dp = new int[s.length()+1];
        
        dp[n] = 1;
        
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) != '0'){
                
                int takeOne = dp[i+1];
        
                int takeTwo = 0;

                if(i<n-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')))
                    takeTwo = dp[i+2];

                dp[i] = takeOne + takeTwo;
            }
        }
        
        return dp[0];
    }
}
