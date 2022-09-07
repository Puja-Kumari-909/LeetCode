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
    public String tree2str(TreeNode root) {
        
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        
        return sb.toString();
    }
    
    public void helper(TreeNode root, StringBuilder sb){
        
        // always append the root data first
        sb.append(root.val);
        
        // if both child null the just return
        if(root.left == null && root.right == null)
            return;
        
        // if left child not null the according to the conditions append the parenthesis
        if(root.left != null){
            sb.append("(");
            helper(root.left, sb);
            sb.append(")");
        }
        
        // if right child not null then there can be two cases either their exist a left child 
        // in that case we have already appended it previously or the left child was null
        // in that case we need to add empty (), to show that in preorder the left is visited 1st
        
        if(root.right != null){
            
            if(root.left == null){
                sb.append("()");
            }
            
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }
}
