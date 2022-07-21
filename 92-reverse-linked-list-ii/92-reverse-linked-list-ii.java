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
        
        ListNode prevIt = null;
        ListNode it = head;
        
        for(int i=0; i<left-1; i++){
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
        
        if(prevIt == null)
            head = prevR;
        else
            prevIt.next = prevR;
        
        it.next = currR;
        
        return head;
    }
}