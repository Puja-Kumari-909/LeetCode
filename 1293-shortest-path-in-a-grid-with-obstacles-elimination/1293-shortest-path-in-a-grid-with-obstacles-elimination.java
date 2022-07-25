class Solution {
    
    class Node{
        int i;
        int j;
        int k;
        
        Node(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    
    public int shortestPath(int[][] grid, int K) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<Node> q = new LinkedList<>();
        
        int[][] vis = new int[rows][cols];
        
        for(int[] arr : vis){
            Arrays.fill(arr, -1);
        }
        
        q.add(new Node(0, 0, K));
        vis[0][0] = K;
        
        int steps = 0;
        
        while(! q.isEmpty()){
            
            int size = q.size();
            
            while(size-- > 0){
                
                Node curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                int k = curr.k;
                
                if(i == rows-1 && j == cols-1){
                    return steps;
                }
                    
                //right
                if(i>=0 && i<rows && j+1<cols){
                    if(grid[i][j+1]==1 && k-1>=0 && k-1>vis[i][j+1]){
                        vis[i][j+1] = k-1;
                        q.add(new Node(i, j+1, k-1));
                    }
                    else if(grid[i][j+1]==0 && k > vis[i][j+1]){
                        vis[i][j+1] = k;
                        q.add(new Node(i, j+1, k));
                    }
                }
                
                //left
                if(i>=0 && i<rows && j-1>=0){
                    if(grid[i][j-1]==1 && k-1>=0 && k-1>vis[i][j-1]){
                        vis[i][j-1] = k-1;
                        q.add(new Node(i, j-1, k-1));
                    }
                    else if(grid[i][j-1]==0 && k > vis[i][j-1]){
                        vis[i][j-1] = k;
                        q.add(new Node(i, j-1, k));
                    }
                }
                
                //up
                if(i-1>=0 && j>=0 && j<cols){
                    if(grid[i-1][j]==1 && k-1>=0 && k-1>vis[i-1][j]){
                        vis[i-1][j] = k-1;
                        q.add(new Node(i-1, j, k-1));
                    }
                    else if(grid[i-1][j]==0 && k > vis[i-1][j]){
                        vis[i-1][j] = k;
                        q.add(new Node(i-1, j, k));
                    }
                }
                
                //down
                if(i+1<rows && j>=0 && j<cols){
                    if(grid[i+1][j]==1 && k-1>=0 && k-1>vis[i+1][j]){
                        vis[i+1][j] = k-1;
                        q.add(new Node(i+1, j, k-1));
                    }
                    else if(grid[i+1][j]==0 && k > vis[i+1][j]){
                        vis[i+1][j] = k;
                        q.add(new Node(i+1, j, k));
                    }
                }
                
            } 
            steps++;
        }
        
        return -1;
    }
}