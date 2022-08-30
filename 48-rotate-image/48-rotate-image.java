class Solution {
    public void rotate(int[][] matrix) {
        
        // take transpose and refection of matrix and it gives the rotation
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i=0; i<r; i++){
            for(int j=i; j<c; j++){
                 int temp = 0;
                 temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp;
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){
               int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}