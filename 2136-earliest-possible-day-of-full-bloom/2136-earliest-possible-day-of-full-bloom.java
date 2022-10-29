class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        
        int[][] pairs = new int[n][2];
        
        for(int i=0; i<plantTime.length; i++){
            pairs[i][0] = plantTime[i];
            pairs[i][1] = growTime[i];
        }
        
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        int plantingDaysCount = 0;
        int totalDays = 0;
        
        for(int[] pair : pairs){
            totalDays = Math.max(totalDays, plantingDaysCount + pair[0] + pair[1]);
            plantingDaysCount += pair[0];
        }
        
        return totalDays;
    }
}