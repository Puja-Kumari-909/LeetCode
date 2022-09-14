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
    
    int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set = new HashSet<>();
        helper(root, set);
        return count;
    }
    
    private void helper(TreeNode root, Set<Integer> set){
        if(root == null) return;
        
        if(set.contains(root.val)){
            set.remove(root.val);
        }
        else
            set.add(root.val);
        
        if(root.left == null && root.right == null){
            if(set.size()<=1)
                count++;
        }
        
        helper(root.left, new HashSet<>(set));
        helper(root.right, new HashSet<>(set));
    }
}