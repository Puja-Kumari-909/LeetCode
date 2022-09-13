class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }
        
        int[] dp = new int[nums.length]; //dp[i] contains the longest divisible subset till index i
        int[] prev = new int[nums.length]; //prev[i] contains the prev index of the element which is taken to form the LDS
        Arrays.sort(nums);
        
        int max = 0;
        int index = -1;
        
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
            prev[i] = -1;
        }
        
        for(int i=1; i<nums.length; i++){
            
            for(int j=i-1; j>=0; j--){ 
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        
        while(index != -1){
            ans.add(nums[index]);
            index = prev[index];
        }
        
        return ans;
    }
}
