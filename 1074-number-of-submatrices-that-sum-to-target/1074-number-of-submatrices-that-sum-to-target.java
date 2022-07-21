class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        
        if(n==0) return 0;
        
        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                mat[i][j] += mat[i][j-1]; 
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for(int startCol=0; startCol<m; startCol++){
            for(int endCol=startCol; endCol<m; endCol++){
                map.clear();
                map.put(0, 1);
                int subMatSum = 0;
                
                for(int row=0; row<n; row++){
                    subMatSum += mat[row][endCol] - (startCol>0 ? mat[row][startCol-1] : 0);
                    
                    if(map.containsKey(subMatSum - target)){
                        int val = map.get(subMatSum-target);
                        count += val; 
                    }
                    
                    map.put(subMatSum, map.getOrDefault(subMatSum, 0) + 1);
                }
            }
        }
        
        return count;
    }
}