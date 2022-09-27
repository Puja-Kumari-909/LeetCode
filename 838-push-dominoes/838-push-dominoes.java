class Solution {
    public String pushDominoes(String dominoes) {
        
        int n = dominoes.length();
        
        int[] leftForce = new int[n];
        int[] rightForce = new int[n];
        
        int nearestLeftIndex = -1;
        int nearestRightIndex = -1;
        
        for(int i=n-1; i>=0; i--){
            if(dominoes.charAt(i) == 'L')
                nearestLeftIndex = i;
            else if(dominoes.charAt(i) == 'R')
                nearestLeftIndex = -1;
               
            leftForce[i] = nearestLeftIndex;
        }
        
        for(int i=0; i<n; i++){
            if(dominoes.charAt(i) == 'R')
                nearestRightIndex = i;
            else if(dominoes.charAt(i) == 'L')
                nearestRightIndex = -1;
               
            rightForce[i] = nearestRightIndex;
        }
        
        char[] ans = new char[n];
        
        for(int i=0; i<n; i++){
            if(dominoes.charAt(i) == '.'){
                int nearestLeft = leftForce[i];
                int nearestRight = rightForce[i];
                
                int leftDistance = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
                int rightDistance = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);
                
                if(leftDistance < rightDistance)
                    ans[i] = 'L';
                else if(rightDistance < leftDistance)
                    ans[i] = 'R';
                else
                    ans[i] = '.';
            }
            else
                ans[i] = dominoes.charAt(i);
        }
        
        return new String(ans);
    }
}