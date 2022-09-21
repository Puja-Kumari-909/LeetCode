class Solution {
    
    // Use nested recursion i.e everytime we find a subset we can again start to find the subset wuth the remaining 
    // elements of array and this can continue until we find k subset with the desired target value or we exhaust all
    // the elemets of array(in that case answer not possible)
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        reverseArray(nums);
        
        int totalSum = Arrays.stream(nums).sum();
        
        if(k<=0 || totalSum % k != 0) return false;
        
        int target = totalSum / k;
        boolean[] visited = new boolean[nums.length];

        return helper(0, target, nums, visited, 0, k);
    }
    
    private boolean helper(int ind, int target, int[] nums, boolean[] visited, int currSum, int k){
        
        if(k == 0) return true; // we have found k distinct subset with the target sum
        
        if(currSum == target){
            
            // we have got one subset with the target value. Now start the search again from beginning to get
            // another subset in the entire array with k-1
            
            return helper(0, target, nums, visited, 0, k-1);
        }
        
        for(int i=ind; i<nums.length; i++){
            
            if(visited[i] || currSum+nums[i]>target)
                continue;
            
            // pruning the unnecessary try of similar combination which failed in last attempt
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1])
                continue;
            
            visited[i] = true;
            
            if(helper(i+1, target, nums, visited, currSum+nums[i], k))
                return true;
                
            visited[i] = false;
        }
        
        return false;
    }
 
    private void reverseArray(int[] arr){
        int i=0;
        int j=arr.length-1;
        
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}