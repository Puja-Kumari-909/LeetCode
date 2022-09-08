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
    public int getMinimumDifference(TreeNode root) {
        
        int[] min = {Integer.MAX_VALUE};
        
        int[] prev = {-1};
        
        helper(root, min, prev);
        
        return min[0];
    }
    
    public void helper(TreeNode root, int[] min, int[] prev){
        
        if(root == null) return;
        
        helper(root.left, min, prev);
        
        if(prev[0] != -1){
            min[0] = Math.min(min[0], Math.abs(root.val - prev[0]));
        }
        
        prev[0] = root.val;
        
        helper(root.right, min, prev);
    }
}