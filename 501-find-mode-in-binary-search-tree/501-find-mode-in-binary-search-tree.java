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
    public int[] findMode(TreeNode root) {
        
        Map<Integer, Integer> fmap = new HashMap<>();
        helper(root, fmap);
        
        int modeValue = 0;
        
        for(Map.Entry<Integer, Integer> val : fmap.entrySet()){
            if(modeValue < val.getValue()){
                modeValue = val.getValue();
            }
        }
        
        List<Integer> mode = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> val : fmap.entrySet()){
            if(val.getValue() == modeValue){
                mode.add(val.getKey());
            }
        }
        
        int[] ans = new int[mode.size()];
        
        for(int i=0; i<ans.length; i++){
            ans[i] = mode.get(i);
        }
        
        return ans;  
    }
    
    public void helper(TreeNode root, Map<Integer, Integer> fmap){
        if(root==null) return;
        
        int value = root.val;
        
        fmap.put(value, fmap.getOrDefault(value, 0)+1);
        
        helper(root.left, fmap);
        helper(root.right, fmap);
        
    }
}