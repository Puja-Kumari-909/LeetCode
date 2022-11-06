class Solution {
    public String orderlyQueue(String s, int k) {
        
        if(k==0)
            return s;
        
        else if(k>1){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        }
        
        else if(k==1){
            String ans = s;
            
            for(int i=0; i<s.length(); i++){
                
                String reorderString = s.substring(i) + s.substring(0, i);
                System.out.println(reorderString);
                
                if(ans.compareTo(reorderString) > 0)
                    ans = reorderString;
            }
            return ans;
        }
        
        return s;
    }
}