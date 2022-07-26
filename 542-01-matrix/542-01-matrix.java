class Solution {
    
    class Pair{
        int i;
        int j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                
                vis[i][j] = true;
                
                if(mat[i][j] == 1){
                    if(ans[i][j] == 0){
                        ans[i][j] = level;
                    }
                }
                
                //up
                if(i-1>=0){
                    if(mat[i-1][j] == 1 && vis[i-1][j] == false){
                        q.add(new Pair(i-1, j));
                    }
                }
                
                
                //down
                if(i+1<n){
                    if(mat[i+1][j] == 1 && vis[i+1][j] == false){
                        q.add(new Pair(i+1, j));
                    }
                }
                
                
                //left
                if(j-1>=0){
                    if(mat[i][j-1] == 1 && vis[i][j-1] == false){
                        q.add(new Pair(i, j-1));
                    }
                }
                
                
                //right
                if(j+1<m){
                    if(mat[i][j+1] == 1 && vis[i][j+1] == false){
                        q.add(new Pair(i, j+1));
                    }
                }
            }
            level++;
        }
        return ans;
    }
}