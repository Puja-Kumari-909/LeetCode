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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            hmap.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, hmap);
    }
    
    public TreeNode helper(int[] pre, int[] in, int preStart,int preEnd, int inStart, int inEnd, Map<Integer, Integer> hmap){
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(pre[preStart]);
        
        int in_index = hmap.get(root.val);
        int nums_left = in_index - inStart;
        
        root.left = helper(pre, in, preStart+1, preStart+nums_left, inStart, in_index-1, hmap);
        root.right = helper(pre, in, preStart+nums_left+1, preEnd, in_index+1, inEnd, hmap);
        
        return root;
    }
}