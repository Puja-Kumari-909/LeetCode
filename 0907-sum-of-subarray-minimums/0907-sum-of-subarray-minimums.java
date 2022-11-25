class Solution {
    
    int mod = 1000000007;
    
    public int sumSubarrayMins(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        
        int len = arr.length;
        
        int[] prevLess = new int[len];
        int[] nextLess = new int[len];
        
        Arrays.fill(prevLess, -1); //if no prev less ele found then we put -1 so that we can calculate whole subarray before this ele
        Arrays.fill(nextLess, len); // if no next less ele found then we put n so that we can calculate whole subarray after this ele
        
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                nextLess[st.pop()] = i;
            }
            st.push(i);
        }
        
        st.clear();
        
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                prevLess[st.pop()] = i;
            }
            st.push(i);
        }
        
        long sum = 0;
        
        for(int i=0; i<len; i++){
            long left = i-prevLess[i];
            long right = nextLess[i] - i;
            
            sum += (arr[i] * left * right) % mod;
        }
        
        return (int) (sum%mod);
    }
}