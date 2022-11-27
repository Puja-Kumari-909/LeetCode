class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        
        for(int i=0; i<nums.length; i++){
            maps[i] = new HashMap<>();
        }
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                
                long commonDiff = (long)nums[i] - (long)nums[j];
                
                if(commonDiff<=Integer.MIN_VALUE || commonDiff >= Integer.MAX_VALUE)
                    continue;
                
                int countTillJ = maps[j].getOrDefault((int)commonDiff, 0);
                int countTillI = maps[i].getOrDefault((int)commonDiff, 0);
                
                ans += countTillJ;
                
                maps[i].put((int)commonDiff, countTillI+countTillJ+1);
            }
        }
        
        return ans;
    }
}