class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int n = changed.length; 
        int ind = 0;
        
        if(n%2 == 1) return new int[0];
        
        int[] ans = new int[n/2];
        
        int[] freq = new int[100007];
        
        for(int num : changed){
            freq[num]++;
        }
        
        for(int i=0; i<freq.length; i++){
            
            while(freq[i]>0 && i*2<100007 && freq[i*2]>0){
                freq[i]--;
                freq[i*2]--;
                ans[ind++] = i;
            }
        }
        
        for(int i=0; i<freq.length; i++){
            if(freq[i] != 0)
                return new int[0];
        }
        
        return ans;
    }
}