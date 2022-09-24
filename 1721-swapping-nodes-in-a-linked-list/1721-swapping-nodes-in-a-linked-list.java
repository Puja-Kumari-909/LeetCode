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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        
        dummy.next = head;
        
        ListNode left = dummy;
        
        ListNode rightFast = head;
        ListNode rightSlow = head;
    
        for(int i=0; i<k; i++)
            if(rightFast != null){
                rightFast = rightFast.next;
                left = left.next;
            }
     
        while(rightFast != null){
            rightSlow = rightSlow.next;
            rightFast = rightFast.next;
        }
            
        int temp = rightSlow.val;
        rightSlow.val = left.val;
        left.val = temp;
  
        return head;
    }
}