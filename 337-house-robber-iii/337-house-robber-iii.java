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
        
    public int rob(TreeNode root) {
        
        Map<TreeNode, Integer> map = new HashMap<>();

        return helper(root, map);
    }
    
    private int helper(TreeNode root, Map<TreeNode, Integer> map){
         if(root == null) return 0;
        
        if(map.containsKey(root))
            return map.get(root);
        
        int leftMax = 0;
        int rightMax = 0;
        
        if(root.left != null){
            leftMax = helper(root.left.left, map) + helper(root.left.right, map);
        }
        
        if(root.right != null){
            rightMax = helper(root.right.left, map) + helper(root.right.right, map);
        }
        
        int val = Math.max(root.val + leftMax + rightMax, helper(root.left, map) + helper(root.right, map));
        map.put(root, val);
        
        return val;
    }
}