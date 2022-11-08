//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Set<ArrayList<String>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j]==1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, list, visited, i, j);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
    
    void dfs(int row, int col, int[][] grid, ArrayList<String> list, boolean[][] visited, int baseRow, int baseCol){
        
        int n = grid.length;
        int m = grid[0].length;
        
        visited[row][col] = true;
        
        list.add(toString(row-baseRow, col-baseCol));
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        for(int i=0; i<4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && grid[nRow][nCol]==1)
                dfs(nRow, nCol, grid, list, visited, baseRow, baseCol);
        }
    }
    
    String toString(int a, int b){
        return Integer.toString(a) + "" + Integer.toString(b);
    }
}
