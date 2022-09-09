class Solution {
    
    // How this problem is different from russion doll?
    // Here the ans is not dependent on the chain of ans. here every ans is only depending on
    // the last maximum value. and thats why greedy works.. 
    
    public int numberOfWeakCharacters(int[][] properties) {
        
        int n = properties.length;
        
        int maxDef = 0;

        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        
        int ans = 0;
        
        for(int i=0; i<n; i++){
            
            if(properties[i][1] < maxDef){
                ans++;
            }
            
            maxDef = Math.max(maxDef, properties[i][1]);
        }
        
        return ans;
    }
}