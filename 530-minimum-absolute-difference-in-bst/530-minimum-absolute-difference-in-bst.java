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
    
    // Iterative Inorder
    
    public int getMinimumDifference(TreeNode root) {
        
        int min = Integer.MAX_VALUE;
        
        Integer prev = null;
        
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode curr = root;
        
        while(curr != null || !st.isEmpty()){
            
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            
            curr = st.pop();
            
            if(prev != null){
                min = Math.min(min, curr.val - prev);
            }
            
            prev = curr.val;
            
            curr = curr.right;
        }
        
        return min;
    }
}