/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    // Same as sorted array to BST. Just need to find mid ele in linkedlist using two pointer approach
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null) return null;
        
        return helper(head, null); //passing low as head and high as null
    }
    
    public TreeNode helper(ListNode low, ListNode high){
        if(low == high) return null;    // here we are comparing two pointers thats why we cant write low>=high
        
        ListNode fast = low;
        ListNode slow = low;
        
        while(fast != high && fast.next != high){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        int mid = slow.val;
        
        TreeNode root = new TreeNode(mid);
        
        root.left = helper(low, slow);
        root.right = helper(slow.next, high);
        
        return root;
    }
}