class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, word, 0, board))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, String word, int ind, char[][] board){
        
        if(ind == word.length())
            return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(ind) 
           || board[i][j] == '*'){
            return false;
        }
            
        char temp = board[i][j];
        
        board[i][j] = '*';
            
        boolean up = dfs(i-1, j, word, ind+1, board);
        boolean down = dfs(i+1, j, word, ind+1, board);
        boolean left = dfs(i, j-1, word, ind+1, board);
        boolean right = dfs(i, j+1, word, ind+1, board);

        board[i][j] = temp;
        
        return up || left || down || right;
    }
}