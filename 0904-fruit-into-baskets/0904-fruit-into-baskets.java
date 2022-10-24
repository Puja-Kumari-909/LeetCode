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

// public int totalFruit(int[] fruits) {
//         // find the maxium sliding window that only contains 2 numbers
//         // use a hashmap to count the occurance and check the size of our hashmap
//        // update right - left + 1 i hashMap size is 2;
//         Map<Integer, Integer> map = new HashMap<>();
//         int res = Integer.MIN_VALUE;
//         // a right pointer and go right and into hashmap
//         // if size is bigger than 2, left pointer starts to shrink
//         int left = 0;
//         for (int right = 0; right < fruits.length; right++) {
//             int curFruit = fruits[right];
//             map.put(curFruit, map.getOrDefault(curFruit, 0) + 1);
//             while (map.size() > 2) {
//                 int leftFruit = fruits[left];
//                 int leftCount = map.get(leftFruit) - 1;
//                 if (leftCount == 0) {
//                     map.remove(leftFruit);
//                 }
//                 else {
//                     map.put(leftFruit, leftCount);
//                 }
//                 left++; // you gotta increment!
//             }
            
//             res = Math.max(right - left + 1, res);
//         }
//         return res == Integer.MIN_VALUE ? 0 : res;
//     }