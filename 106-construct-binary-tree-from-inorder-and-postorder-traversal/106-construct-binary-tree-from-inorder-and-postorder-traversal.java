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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //build the hashmap to get the index of ele in the inorder in O(1) time
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            hmap.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, hmap);
    }
    
    public TreeNode helper(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> hmap){
        if(inStart>inEnd || postStart>postEnd)
            return null;
        
        TreeNode root = new TreeNode(post[postEnd]);
        
        int inRoot = hmap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(in, post, inStart, inRoot - 1, postStart, postStart + numsLeft - 1, hmap);
        root.right = helper(in, post, inRoot+1, inEnd, postStart + numsLeft, postEnd - 1, hmap);
        
        return root;
    }
}