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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair{
        int i;
        int j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        
        
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