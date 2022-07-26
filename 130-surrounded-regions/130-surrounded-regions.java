class Solution {
    
    // use bfs to push all the border zeros and mark all connected Os to safe
    // again traverse the matrix and mark remaining Os to X and safe boxes back to O
    // both dfs and bfs can be used to find the connected component and mark it safe
    
    class Pair{
        int i;
        int j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public void solve(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(i==0 || j==0 || i==rows-1 || j==cols-1){
                    if(grid[i][j] == 'O'){
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                
                grid[i][j] = 'S';
                
                //up
                if(i-1>=0 && grid[i-1][j] == 'O'){
                    q.add(new Pair(i-1, j));
                }
                
                //down
                if(i+1<rows && grid[i+1][j] == 'O'){
                    q.add(new Pair(i+1, j));
                }
                
                //left
                if(j-1>=0 && grid[i][j-1] == 'O'){
                    q.add(new Pair(i, j-1));
                }
                
                //right
                if(j+1<cols && grid[i][j+1] == 'O'){
                    q.add(new Pair(i, j+1));
                }
            }
        }
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 'O')
                    grid[i][j] = 'X';
                else if(grid[i][j] == 'S')
                    grid[i][j] = 'O';
            }
        }
    }
}