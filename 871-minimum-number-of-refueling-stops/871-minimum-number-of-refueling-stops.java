class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int maxReach = startFuel;
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int index = 0;
        
        while(maxReach < target){
            
            while(index<stations.length && stations[index][0] <= maxReach){
                pq.offer(stations[index][1]);
                index++;
            }
            
            if(pq.isEmpty()) return -1;
            
            maxReach += pq.poll();
            count++;
        }
        
        return count;
    }
}