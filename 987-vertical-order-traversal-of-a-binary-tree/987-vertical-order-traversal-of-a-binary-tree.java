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
    
    class Tuple{
        
        TreeNode node;
        int verticalLevel;
        int depth;
        
        public Tuple(TreeNode n, int v, int d){
            node = n;
            verticalLevel = v;
            depth = d;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();
        
        q.add(new Tuple(root, 0, 0));
        
        while(!q.isEmpty()){
            
            Tuple curr = q.poll();
            
            TreeNode node = curr.node;
            int verticalLevel = curr.verticalLevel;
            int depth = curr.depth;
            
            if(!map.containsKey(verticalLevel)){
                map.put(verticalLevel, new TreeMap<>());
            }
            
            if(!map.get(verticalLevel).containsKey(depth)){
                map.get(verticalLevel).put(depth, new PriorityQueue < > ());
            }
            
            map.get(verticalLevel).get(depth).offer(node.val);
            
            if (node.left != null) {
                q.offer(new Tuple(node.left, verticalLevel - 1, depth + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, verticalLevel + 1, depth + 1));
            }
               
        }
        
        List<List<Integer>> list = new ArrayList <>();

         for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList <> ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}