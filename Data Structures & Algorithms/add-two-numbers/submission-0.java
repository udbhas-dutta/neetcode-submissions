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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }
    public ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0) return null;

        int a = 0, b = 0;
        if(l1 !=null) a = l1.val;
        if(l2!= null ) b = l2.val;
        int sum = a+b+carry;
        int store = sum%10, newCarry = sum/10;

        ListNode nextNode = helper((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, newCarry);

        return new ListNode(store, nextNode);

    }
}
