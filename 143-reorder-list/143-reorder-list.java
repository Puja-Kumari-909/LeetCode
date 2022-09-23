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
    
    // 3 steps --> 1st Find mid, 2nd reverse the second half and split the two halves, 3rd Merge the two halves
    
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode head2 = reverseHalf(slow.next);
//         while(head2 != null){
//             System.out.print(head2.val+" ");
//             head2 = head2.next;
//         }
//         System.out.println();
        
        //Cut the first half
        slow.next = null; 
        
        
        //  while(head != null){
        //     System.out.print(head.val+" ");
        //     head = head.next;
        // }
        
        // Merge the two parts together
        while(head != null && head2 != null){
            
            ListNode headNext = head.next;
            ListNode head2Next = head2.next;
            
            head.next = head2;
            head2.next = headNext;
            
            head = headNext;
            head2 = head2Next;
        }
        
    }
    
    private ListNode reverseHalf(ListNode node){
        
        ListNode prev = null;
        ListNode curr = node;
        
        while(curr != null){
            
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}