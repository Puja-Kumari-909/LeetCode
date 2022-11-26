class Solution {
    
    private class Job{
        int start;
        int end;
        int profitMade;
        
        public Job(int s, int e, int p){
            start = s;
            end = e;
            profitMade = p;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<Job> jobs = new ArrayList<>();
        
        for(int i=0; i<startTime.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        Collections.sort(jobs, (a, b) -> (a.end-b.end));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        
        for(Job currJob : jobs){
            Integer entryTillStartTime = map.floorKey(currJob.start);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            ans = Math.max(ans, maxProfitTillStartTime + currJob.profitMade);
            map.put(currJob.end, ans);
        }
        
        return ans;
    }
}