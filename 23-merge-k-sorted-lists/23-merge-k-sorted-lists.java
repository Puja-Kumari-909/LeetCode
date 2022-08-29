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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Put the first node of each list
        for(ListNode firstNode : lists){
            if(firstNode != null)
                pq.add(firstNode);
        }
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        // keep pulling out elements from pq and add the next node of the curr node if exist 
        while(!pq.isEmpty()){
            
            ListNode temp = pq.poll();
            
            curr.next = temp;
            
            curr = curr.next;
            
            if(temp.next != null)
                pq.add(temp.next);
        }
        
        return head.next;
    }
}