/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        setParentPointers(root, map);
        
        findAllNodes(target, k, ans, map);
        
        return ans;
    }
    
    public void findAllNodes(TreeNode start, int k, List<Integer> ans, Map<TreeNode, TreeNode> map){
        
        Queue<TreeNode> q = new LinkedList<>();
        
        Set<TreeNode> visited = new HashSet<>();
        
        q.add(start);
        visited.add(start);
        
        int distance = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-- > 0){
                
                TreeNode curr = q.poll();
                
                if(distance == k)
                    ans.add(curr.val);
                
                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                
                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                
                if(map.get(curr) != null && !visited.contains(map.get(curr))){
                    q.add(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
            
            distance++;
        }
        
    }
    
    public void setParentPointers(TreeNode root, Map<TreeNode, TreeNode> map){
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode temp = q.poll();
            
            if(temp.left != null){
                map.put(temp.left, temp);
                q.add(temp.left);
            }
            
            if(temp.right != null){
                map.put(temp.right, temp);
                q.add(temp.right);
            }
        }
    }
}