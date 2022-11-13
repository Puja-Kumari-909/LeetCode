class Solution {
    public String reverseWords(String s) {
    
        StringBuilder sb = new StringBuilder();
        
        int n = s.length();
        
        int i = n-1;
        
        while(i>=0){
            
            while(i>=0 && s.charAt(i)==' ') 
                i--;
            
            int j = i;
            
            if(i<0) break;
            
            while(i>=0 && s.charAt(i)!=' ')
                i--;
            
            if(sb.isEmpty()){
                sb.append(s.substring(i+1, j+1));
            }
            else{
                sb.append(" ");
                sb.append(s.substring(i+1, j+1));
            }
               
        }
        
        return sb.toString();
    }
}