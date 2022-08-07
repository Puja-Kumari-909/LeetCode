class Solution {
    
    private long[][] dp;
    private int MOD = (int)1e9 + 7;
    
    // a, e, i, o, u is represented by 0, 1, 2, 3, 4 respectively in dp array
    
    public int countVowelPermutation(int n) {
        dp = new long[6][n+1]; //dp[i][j] denotes a string ending with character i having len j
        
        if(n==1) return 5;
        
        for(int i=0; i<5; i++){
            dp[i][0] = 1;       //there is one possibility of generating one length string with all the vowels taken
        }
        
        helper(n, 'f');     // f denotes that there was no character previous to this character
        
        return (int) dp[5][n];
    }
    
    private long helper(int n, char vowel){
        long ans = 0;
        
        if(n==0) return 1;
        
        // if f then we can form 5 strings taking every vowel once
        if(vowel == 'f'){
            ans = (ans + helper(n-1, 'a') + helper(n-1, 'e') + helper(n-1, 'i') + helper(n-1, 'o') + helper(n-1, 'u'))%MOD;
            dp[5][n] = ans;
        }
        
        //keep on checking for all vowels and with respect to the conditions given generate strings of len n
        
        else if(vowel == 'a'){
            if(dp[0][n] != 0) return dp[0][n];
            ans = (ans + helper(n-1, 'e'))%MOD;
            dp[0][n] = ans;
        }
        
        else if(vowel == 'e'){
            if(dp[1][n] != 0) return dp[1][n];
            ans = (ans + helper(n-1, 'a') + helper(n-1, 'i'))%MOD;
            dp[1][n] = ans;
        }
        
        else if(vowel == 'i'){
            if(dp[2][n] != 0) return dp[2][n];
            ans = (ans + helper(n-1, 'a') + helper(n-1, 'e') + helper(n-1, 'o') + helper(n-1, 'u'))%MOD;
            dp[2][n] = ans;
        }
        
        else if(vowel == 'o'){
            if(dp[3][n] != 0) return dp[3][n];
            ans = (ans + helper(n-1, 'i') + helper(n-1, 'u'))%MOD;
            dp[3][n] = ans;
        }
        
        else if(vowel == 'u'){
            if(dp[4][n] != 0) return dp[4][n];
            ans = (ans + helper(n-1, 'a'))%MOD;
            dp[4][n] = ans;
        }
        
        return ans;
    }
}