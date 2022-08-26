class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i =  m + n - 1;
        int tail2 = n - 1;
        int tail1 = m - 1;
        
        while(tail1>=0 && tail2>=0){
            if(nums1[tail1]>nums2[tail2]){
                nums1[i] = nums1[tail1];
                tail1--;
                i--;
            }
            else{
                nums1[i] = nums2[tail2];
                tail2--;
                i--;
            }
        }
        
        while(tail2 >= 0){
            nums1[i] = nums2[tail2];
            tail2--;
            i--;
        }
    }
}