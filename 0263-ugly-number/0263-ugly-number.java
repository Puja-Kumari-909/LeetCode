class Solution {
    public boolean isUgly(int n) {
        
        if(n<=0)
            return false;
        
        int[] primeNum = {2, 3, 5};
        
        for(int num : primeNum){
            n = divideByPrime(n, num);
        }
        
        if(n==1)
            return true;
        
        return false;
    }
    
    private int divideByPrime(int n, int num){
        
        while(n%num == 0)
            n = n/num;
        
        return n;
    }
}