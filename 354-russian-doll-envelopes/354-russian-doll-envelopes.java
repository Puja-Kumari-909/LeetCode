class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes.length == 1) return 1;
        
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1]-a[1] : a[0] - b[0]);
        
        List<Integer> list = new ArrayList<>();
        
        list.add(envelopes[0][1]);
        int len = 1;
        
        for(int row = 1; row < envelopes.length; row++){
            
            if(envelopes[row][1] > list.get(list.size() - 1)){
                list.add(envelopes[row][1]);
                len++;
            }
            else{
                int position = getIndex(list, envelopes[row][1]);
                list.set(position, envelopes[row][1]);
            }
        }
        
        return len;
    }
    
    private int getIndex(List<Integer> list, int target){
        
        int low = 0;
        int high = list.size()-1;
        
        int ind = 0;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(list.get(mid) == target)
                return mid;
            
            if(list.get(mid)>target){
                ind = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        
        return ind;
    }
}
