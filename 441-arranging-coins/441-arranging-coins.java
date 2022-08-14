class Solution {
    
    // this problem is good binary search problem. here we need to think in diff way just like
    // book allocation and aggresive cows. First find the search space. So min can be 1 since n>=1 
    // and max can be the nth row itself. Now the number of coins requried to fill up till any 
    // level x is 1+2+3+....+x = x(x+1)/2. We find the mid every time and then by using the formula     // we know how many coins are needed to fill till this level. Now if we have exactly n coins       // needed to fill till this level then we can simply return from there bcz it is not possible       // to fill up any further level. If we have more number of coins left even after filling up 
    // till this level then we can go ahead and try to maximise the levels to meet the answer. If       // we have less number of coins then the actual needed number then we can try to go some level     // back so that we can get the answer.
    public int arrangeCoins(int n) {
        
        long low = 0;
        long high = n;
        
        while(low<=high){
            
            long mid = low + (high - low)/2;
            
            long requriedNumOfCoins = mid*(mid+1)/2;
            
            if(requriedNumOfCoins==n) return (int) mid;
            
            if(requriedNumOfCoins>n){
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return (int)high;
    }
}