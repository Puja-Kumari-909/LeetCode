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
    
    // this problem can be divided into two problems
    // 1st is to find the mid of the list
    // 2nd is to merge the broken sorted sublist to get back the entire list
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = getMid(head);
        
        System.out.println(mid.val);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
        
    }
    
    public ListNode merge(ListNode left, ListNode right){
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(left != null && right != null){
            
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
                curr = curr.next;
            }
            else{
                curr.next = right;
                right = right.next;
                curr = curr.next;
            }
        }
        
        while(left != null){
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }
        
        while(right != null){
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    public ListNode getMid(ListNode head){
        
        // this step is required to cut the linkedlist into half
        ListNode prev = null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;        // move this pointer with slow so that we can modify the next of slow to null
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;   //everytime we find the mid and we set its next to null so that we cut the entire list in half
        return slow;
    }
}