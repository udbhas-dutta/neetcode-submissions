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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode h1 = head, h2 = reverse(slow.next);
        slow.next = null;
        // System.out.println(h2.val);
        // while(h2.next!= null){
        //     System.out.println(h2.val);
        //     h2 = h2.next;
        // }
        ListNode temp = new ListNode(-1);
        
        while(h1 != null && h2 != null){
            ListNode n1 = h1.next, n2 = h2.next;
            temp.next = h1;
            temp.next.next = h2;
            
            h1 = n1;
            h2 = n2;

            temp = temp.next.next;
            
        }
        if(h1 != null){
            temp.next = h1;
        }
        if(h2 != null){
            temp.next = h2;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
