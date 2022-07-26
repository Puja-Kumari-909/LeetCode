class Solution {
    
    // start with all the rotten oranges as root and keep making all adj oranges rotten until no further oranges can be traversed from the rotten once
    
    class Pair{
        int i;
        int j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean containsRotten = false;
        boolean containsFresh = false;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    containsRotten = true;
                }
                else if(grid[i][j] == 1){
                    containsFresh = true;
                }
            }
        }
        
        if(!containsRotten){
            if(!containsFresh)
                return 0;
            else
                return -1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }
            }
        }
        
        
        int mint = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                
                //up
                if(i-1>=0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    q.add(new Pair(i-1, j));
                }
                
                //down
                if(i+1<rows && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    q.add(new Pair(i+1, j));
                }
                
                //left
                if(j-1>=0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    q.add(new Pair(i, j-1));
                }
                
                //right
                if(j+1<cols && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    q.add(new Pair(i, j+1));
                }
                
            }
            mint++;
        }
        
        boolean isRotten = true;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    isRotten = false;
                }
            }
        }
        
        return isRotten ? mint-1 : -1;
    }
}