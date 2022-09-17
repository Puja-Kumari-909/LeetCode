class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int sizeOfArray = nums.length;
        
        int[] lis = new int[sizeOfArray];
        int[] countLis = new int[sizeOfArray];
        
        Arrays.fill(lis, 1);
        Arrays.fill(countLis, 1);
        
        int max = 1;
        
        for(int i=1; i<sizeOfArray; i++){
            for(int j=i-1; j>=0; j--){
                
                if(nums[i]>nums[j] && lis[j]+1 > lis[i]){
                    lis[i] = lis[j]+1;
                    countLis[i] = countLis[j];
                }
                else if(nums[i]>nums[j] && lis[j]+1 == lis[i]){
                    countLis[i] += countLis[j];
                }
                
                max = Math.max(max, lis[i]);
            }
        }
        
        int noOfLis = 0;
        
        for(int i=0; i<sizeOfArray; i++){
            if(lis[i] == max){
                noOfLis += countLis[i];
            }
        }
        
        return noOfLis;
    }
}