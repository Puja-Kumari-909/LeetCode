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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null) return head;
        
        if(left==right) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevIt = null;
        
        ListNode it = dummy;
        
        for(int i=0; i<left; i++){
            prevIt = it;
            it = it.next;
        }
        
        ListNode prevR = prevIt;
        ListNode currR = it;
        
        
        for(int i=left; i<=right; i++){
            ListNode nextR = currR.next;
            currR.next = prevR;
            prevR = currR;
            currR = nextR;
        }
        
        if(prevIt != null)
            prevIt.next = prevR;
        else
            head = prevR;
        
        it.next = currR;
        
        return dummy.next;
    }
}