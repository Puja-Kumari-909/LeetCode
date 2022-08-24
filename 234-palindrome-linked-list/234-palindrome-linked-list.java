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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        } 
        
        // reverse the second half
        
        ListNode prev = null;
        
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        // now check if the two halves are equal
        
        fast = head;
        slow = prev;
        
        while(fast != null && slow != null){
            if(fast.val != slow.val)
                return false;
            
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
}