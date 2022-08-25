class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] ans = new int[nums.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums){
            pq.add(num * num);
        }
        
        int ind = 0;
        while(!pq.isEmpty()){
            ans[ind++] = pq.poll();
        }
        
        return ans;
    }
}