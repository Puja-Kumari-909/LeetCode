class Solution {
    public String reverseWords(String s) {
    
        if(s.length() == 1) return s;
        
        char[] c = s.toCharArray();
        int n = c.length;
        
        int i = 0;
        int l = 0;
        
        while(i<n){
            
            if(Character.isWhitespace(c[i]) || i==n-1){
                
                int r = i == n-1 ? i : i - 1; 
                
                while(l<r){
                    char temp = c[l];
                    c[l++] = c[r];
                    c[r--] = temp;
                    
                }
                
                if(i+1<n)
                    l = i+1;
            }
            
            i++;
        }
        
        return new String(c);
    }
}