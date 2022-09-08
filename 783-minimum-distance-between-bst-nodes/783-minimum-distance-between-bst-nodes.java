/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    
    public int minDiffInBST(TreeNode root) {
        
        int[] min = {Integer.MAX_VALUE};
        
        // we are taking this insted of int var bcz when we pass the modified val of this to next 
        // function then that works fine but when recursion backtracks to original function the val
        // of that premitive var is still unchanged which is -1. That's why we loose some calculation
        // and we take this array of size one so that the actual object is modified and the change remains
        // even after recursion backtracks
        
        int[] prevElement = {-1};
        
        helper(root, min, prevElement);
        
        return min[0];
    }
    
    private void helper(TreeNode root, int[] min, int[] prevEle){
        
        if(root == null)
            return;
        
        helper(root.left, min, prevEle);
        
        if(prevEle[0] != -1){
            
            int currDiff = root.val - prevEle[0];
            
            min[0] = Math.min(min[0], currDiff);
            
            System.out.println("diff " + currDiff);

        }
        prevEle[0] = root.val;
        System.out.println("prev " + prevEle[0]);
        helper(root.right, min, prevEle);
        
    }
}