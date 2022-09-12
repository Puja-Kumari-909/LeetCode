class Solution {
    
    
    // Greedly pick the elemets which require minimum power. If power becomes less then trade off the score with the
    // element which can increase the power to the maximun possible value which is the greatest elements on right 
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        
        int left = 0;
        int right = tokens.length - 1;
        
        int score = 0;
        int maxScore = 0;
        
        while(left<=right){
            
            if(power>=tokens[left]){
                score++;
                power -= tokens[left];
                left++;
                maxScore = Math.max(score, maxScore);
            }
            
            else if(score > 0){
                score--;
                power += tokens[right];
                right--;
                maxScore = Math.max(score, maxScore);
            }                              
            else
                break;
        }
        
        return maxScore;
    }
}