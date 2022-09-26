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
    
    // Find lowest common ancestor. 
    // Build path from LCA to both start and end.
    // Replace all the characters of the path from LCA to start to U
    //(since we have to build the path from start to LCA and then to dest)
    
    public String getDirections(TreeNode root, int s, int d) {
        
        TreeNode lca = getLCA(root, s, d);
        
        // System.out.println(lca.val);
        
        List<String> buildLcaToStart = new ArrayList<>();
        List<String> buildLcaToDest = new ArrayList<>();
    
        buildPath(lca, s, buildLcaToStart);
        
//         for(var a : buildLcaToStart) 
//             System.out.print(a);
        
//         System.out.println();
        
        buildPath(lca, d, buildLcaToDest);
        
        //  for(int i=0; i<buildLcaToDest.size(); i++){
        //     System.out.print(buildLcaToDest.get(i));
        // }

        StringBuilder path = new StringBuilder();
        
        for(int i=0; i<buildLcaToStart.size(); i++) path.append("U");
        
        for(String str : buildLcaToDest)
            path.append(str);
        
        return path.toString();
    }

    private boolean buildPath(TreeNode root, int val, List<String> temp){
       
        if(root == null) return false;
        
        if(root.val == val) return true;
        
        temp.add("L");
        if(buildPath(root.left, val, temp)) return true;
        temp.remove(temp.size() - 1);
        
        temp.add("R");
        if(buildPath(root.right, val, temp)) return true;
        temp.remove(temp.size() - 1);
        
        return false;
    }
    
    private TreeNode getLCA(TreeNode root, int s, int d){
        if(root == null || root.val == s || root.val == d)
            return root;
        
        TreeNode left = getLCA(root.left, s, d);
        TreeNode right = getLCA(root.right, s, d);
        
        if(left != null && right != null) return root;
        
        return left == null ? right : left;
    }
}