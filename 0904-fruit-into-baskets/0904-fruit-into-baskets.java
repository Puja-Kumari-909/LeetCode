class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int ans = Integer.MIN_VALUE;
        
        int left = 0;
        int size = fruits.length;
        
        for(int right = 0; right<size; right++)
        {
            int currEle = fruits[right];
            
            map.put(currEle, map.getOrDefault(currEle, 0) + 1);
            
            while(map.size()>2){
                
                int leftEle = fruits[left];
                int leftEleCount = map.get(leftEle);
                
                if(leftEleCount == 1)
                    map.remove(leftEle);
                else
                    map.put(leftEle, leftEleCount-1);
                
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans == Integer.MIN_VALUE ? 0 : ans; 
    }
}