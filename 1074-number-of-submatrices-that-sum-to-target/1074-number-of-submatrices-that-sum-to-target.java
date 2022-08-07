class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int sum = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += matrix[i][j];
                matrix[i][j] = sum;
            }
            sum = 0;
        }
        
        Map<Integer, Integer> hmap = new HashMap<>();
        
        int count = 0;
        
        for(int startCol=0; startCol<m; startCol++){
            for(int endCol=startCol; endCol<m; endCol++){
                hmap.clear();
                hmap.put(0, 1);
                
                int subMatSum = 0;
                
                for(int row=0; row<n; row++){
                    subMatSum += matrix[row][endCol] - (startCol==0 ? 0 : matrix[row][startCol-1]);
                    
                    if(hmap.containsKey(subMatSum - target)){
                        int val = hmap.get(subMatSum - target);
                        count += val;
                    }
                    
                    hmap.put(subMatSum, hmap.getOrDefault(subMatSum, 0) + 1);
                }
            }
        }
        return count;
    }
}