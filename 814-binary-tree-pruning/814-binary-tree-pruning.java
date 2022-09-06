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
    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }
    
    public TreeNode helper(TreeNode root){
        if(root == null) return null;
        
        TreeNode curr = new TreeNode(root.val);
        
        curr.left = helper(root.left);
        curr.right = helper(root.right);
        
        if(curr.val == 0 && curr.left == null && curr.right == null) return null; 
        
        return curr;
    }
}