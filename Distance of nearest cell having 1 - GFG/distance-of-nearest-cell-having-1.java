//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair{
        int x, y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] ans = new int[row][col];
        boolean[][] vis = new boolean[row][col];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        
        int steps = 0;
        
        int[] xDir = {-1, 0, 1, 0};
        int[] yDir = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-- > 0){
                Pair temp = q.poll();
                int i = temp.x;
                int j = temp.y;
                
                if(grid[i][j] == 0){
                    ans[i][j] = steps;
                }
                
                for(int k=0; k<4; k++){
                    int nRow = i + xDir[k];
                    int nCol = j + yDir[k];
                    
                    if(nRow>=0 && nRow < row && nCol>=0 && nCol < col && !vis[nRow][nCol]){
                        vis[nRow][nCol] = true;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
            
            steps++;
        }
        
        return ans;
    }
}