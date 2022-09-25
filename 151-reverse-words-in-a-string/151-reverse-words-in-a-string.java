class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");
    
        StringBuilder sb = new StringBuilder();
        
        int n = words.length;
        
        for(int i=0; i<n; i++){
            if(!words[i].isEmpty()){
                sb.insert(0, words[i]);
                if(i<n-1) sb.insert(0, " ");
            }
        }
        
        return sb.toString();
    }
}