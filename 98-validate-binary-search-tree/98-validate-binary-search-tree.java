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
    public boolean isValidBST(TreeNode root) {
        
        // pass null, null as this is the root of the tree so we dont have any parent of this node
        return helper(root, null, null);
    }
    
    // Integer is taken so that we can compare > < with the current node
    private boolean helper(TreeNode node, Integer minVal, Integer maxVal){
        if(node == null) return true;
        
        // verify if the curr left child node violates the BST condition
        if(maxVal != null && node.val >= maxVal)
            return false;
        
        // verify if the curr right child node violates the BST condition
        if(minVal != null && node.val <= minVal)
            return false;
        
        // call the left child with the maxVal as the curr parent node and right child with the mixVal as curr parent node
        return helper(node.left, minVal, node.val) && helper(node.right, node.val, maxVal);
    }
}