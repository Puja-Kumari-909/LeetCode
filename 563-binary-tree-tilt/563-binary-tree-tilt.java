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
    public int findTilt(TreeNode root) {
        int[] ans = new int[1];
        helper(root, ans);
        
        return ans[0];
    }
    
    private int helper(TreeNode root, int[] ans){
        if(root == null) return 0;
        
        int left = helper(root.left, ans);
        int right = helper(root.right, ans);
        
        ans[0] += Math.abs(left - right);
        
        return left + right + root.val;
    }
}