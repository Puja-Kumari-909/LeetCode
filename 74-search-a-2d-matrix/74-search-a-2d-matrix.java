class Solution {
    
    
    // we are doing two times binary search since we know that the last ele of prev row is less than
    // first ele of curr row. 1st time binary search is done on the rows to find the exact row where 
    // the target might lie. Then on that row we do binary search to know if actually target lies.
    
    // this solution does not work if we dont have the condition given i.e the last ele of prev 
    // row is less than first ele of curr row. 
    
    
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int startRow = 0;       
        int endRow = rows - 1;      
        
        while(startRow<=endRow){
            
            int mid = startRow + (endRow - startRow)/2;         
            
            if(matrix[mid][0]<=target && target <= matrix[mid][cols-1]){
                return binarySearch(matrix, target, mid);
            }
            
            if(matrix[mid][0] > target)
                endRow = mid - 1;       // up
            
            else
                startRow = mid + 1;     // down
            
        }
        
        return false;
    }
    
    public boolean binarySearch(int[][] matrix, int target, int row){
        
        int l = 0;
        int r = matrix[0].length-1;
        
        System.out.println(row);     // 1
        
        while(l<=r){
            
            int mid = l + (r-l) / 2;
            
            if(matrix[row][mid] == target) return true;
            
            if(matrix[row][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return false;
    }
}