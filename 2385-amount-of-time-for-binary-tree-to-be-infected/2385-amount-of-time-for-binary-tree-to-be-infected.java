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
    public int amountOfTime(TreeNode root, int start) {
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        TreeNode target = setParentPointer(root, start, map);
        // System.out.println(target.val);
        
        int time = getTime(target, map);
        
        return time;
    }
    
    public int getTime(TreeNode target, Map<TreeNode, TreeNode> map){
        
        Queue<TreeNode> q = new LinkedList<>();
        
        Set<TreeNode> vis = new HashSet<>();
        
        q.add(target);
        vis.add(target);
        int time = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            boolean isInfected = false;
            
            while(size-- > 0){
                
                TreeNode temp = q.poll();
                
                if(temp.left != null && !vis.contains(temp.left)){
                    vis.add(temp.left);
                    q.add(temp.left);
                    isInfected = true;
                }
                
                if(temp.right != null && !vis.contains(temp.right)){
                    vis.add(temp.right);
                    q.add(temp.right);
                    isInfected = true;
                }
                
                if(map.get(temp) != null && !vis.contains(map.get(temp))){
                    vis.add(map.get(temp));
                    q.add(map.get(temp));
                    isInfected = true;
                }
            }
            
            if(isInfected) time++;
            System.out.println(time);
        }
        
        return time;
    }
    
    public TreeNode setParentPointer(TreeNode root, int start, Map<TreeNode, TreeNode> map){
        
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode target = new TreeNode();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode temp = q.poll();
            
            if(temp.val == start) target = temp;
            
            if(temp.left != null){
                q.add(temp.left);
                map.put(temp.left, temp);
            }
            
            if(temp.right != null){
                q.add(temp.right);
                map.put(temp.right, temp);
            }
        }
        
        return target;
    }
}