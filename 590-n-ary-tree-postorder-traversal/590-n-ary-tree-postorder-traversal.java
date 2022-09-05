/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        
        List<Integer> ans = new ArrayList<>();
        
        helper(root, ans);
        
        return ans;
    }

    public void helper(Node root, List<Integer> ans){
        if(root == null) return;
        
        for(Node child : root.children){
            helper(child, ans);
        }
        
        ans.add(root.val);
    }
}