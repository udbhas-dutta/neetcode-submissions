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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a.val));
        for(ListNode list: lists){
            if(list != null) pq.offer(list);
        }

        ListNode start = new ListNode(-1);
        ListNode temp = start;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;

            curr = curr.next;
            if(curr!= null) pq.offer(curr);
        } 
        return start.next;
    }
}
