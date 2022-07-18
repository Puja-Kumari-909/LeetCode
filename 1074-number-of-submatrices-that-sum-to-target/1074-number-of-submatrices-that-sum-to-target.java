class Solution {
    public int numSubmatrixSumTarget(int[][] m, int target) {
        
        int rows = m.length;
        int cols = m[0].length;
        
        if(rows == 0) return 0;
        
        // calculate the running sum of each row
        for(int i=0; i<m.length; i++){
            for(int j=1; j<m[i].length; j++){
                m[i][j] += m[i][j-1];
            }
        }
        
        // iterate over each submatrix which is formed by two cols and a row and calculate sum
    
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int startCol=0; startCol < cols; startCol++){
            for(int endCol=startCol; endCol < cols; endCol++){
                
                map.clear();
                int currSubMatrixSum = 0;
                map.put(0, 1);
                
                for(int row = 0; row<rows; row++){
                   
                    currSubMatrixSum += m[row][endCol] - (startCol>0 ? m[row][startCol-1] : 0);
                    
                    count += map.getOrDefault((currSubMatrixSum - target) , 0);
                    
                    map.put(currSubMatrixSum, map.getOrDefault(currSubMatrixSum, 0) + 1);
                }
            }
        }
        
        return count;
    }
}