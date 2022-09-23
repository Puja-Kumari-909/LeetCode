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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i=1; i<=n; i++)
            fast = fast.next;
        
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }
        
        prev.next = slow.next;
        
        return dummy.next;
    }
}