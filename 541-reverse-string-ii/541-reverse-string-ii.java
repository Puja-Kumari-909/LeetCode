class Solution {
    public String reverseStr(String s, int k) {
        
        char[] c = s.toCharArray();
        int n = c.length;
        
        // move 2k steps and reverse the first k characters
        for(int i=0; i<n; i += 2*k){
            
            int l = i;
            int r = Math.min(i+k-1, c.length - 1);
            
            while(l<r){
                char temp = c[l];
                c[l] = c[r];
                c[r] = temp;
                l++;
                r--;
            }
        }
        
        return new String(c);
    }
}