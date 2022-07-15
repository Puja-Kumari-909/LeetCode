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
        
        return helper(0, 0, inorder.length-1, preorder, inorder, hmap);
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> hmap){
        if(preStart>=preorder.length || inStart>inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int in_index = hmap.get(root.val);
        int numsLeft = in_index - inStart + 1;
        
        root.left = helper(preStart+1, inStart, in_index-1, preorder, inorder, hmap);
        root.right = helper(preStart+numsLeft, in_index+1, inEnd, preorder, inorder, hmap);
        
        return root;
    }
}