//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        int[][] vis = new int[n][m];
        
        for(int j=0; j<m; j++){
            
            if(vis[0][j] == 0 && a[0][j] == 'O')
                dfs(0, j, vis, a, delRow, delCol);
            
            if(vis[n-1][j] == 0 && a[n-1][j] == 'O')
                dfs(n-1, j, vis, a, delRow, delCol);
        }
        
        for(int i=0; i<n; i++){
            
            if(vis[i][0] == 0 && a[i][0] == 'O')
                dfs(i, 0, vis, a, delRow, delCol);
            
            if(vis[i][m-1] == 0 && a[i][m-1] == 'O')
                dfs(i, m-1, vis, a, delRow, delCol);
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && a[i][j] == 'O')
                    a[i][j] = 'X';
            }
        }
        
        return a;
    }
    
    static void dfs(int i, int j, int[][] vis, char[][] arr, int[] delRow, int[] delCol){
        
        vis[i][j] = 1;
        
        int n = arr.length;
        int m = arr[0].length;
        
        for(int k=0; k<4; k++){
            int nwRow = i + delRow[k];
            int nwCol = j + delCol[k];
            
            if(nwRow >=0 && nwRow < n && nwCol >= 0 && nwCol < m && vis[nwRow][nwCol] == 0 && arr[nwRow][nwCol] == 'O')
                dfs(nwRow, nwCol, vis, arr, delRow, delCol);
        }
    }
}