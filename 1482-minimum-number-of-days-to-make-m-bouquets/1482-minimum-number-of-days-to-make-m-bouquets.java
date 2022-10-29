class Solution {
    
    // Similar to Aggrasive cows and book allocation problem
    // here the range is the max and min value of the day and we try to find the minimum day when its possible
    // to make the bouquets by binary search
    
    public int minDays(int[] bloomDay, int m, int k) {
        
       int max = Integer.MIN_VALUE, len = bloomDay.length;
        
        for (int i = 0; i < len; i++) {
            if (bloomDay[i] > max)
                max = bloomDay[i];
        }

        int lo = 1, hi = max, ans = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }

        return ans;
    }

    public boolean isPossible(int[] bloomDay, int m, int k, int days) {

        int len = bloomDay.length, count = 0, adjacent = 0;
        
        for (int i = 0; i < len; i++) {

            if (bloomDay[i] <= days) {
                adjacent++;
                if (adjacent == k) {
                    count++;
                    if (count == m)
                        return true;
                    adjacent = 0;
                }
            } else
                adjacent = 0;
        }
        return false;
    }
}