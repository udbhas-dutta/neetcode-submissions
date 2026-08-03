/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr!= null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        Node temp = new Node(-1);
        Node ans = temp;
        curr = head;
        while(curr != null){
            temp.next = map.get(curr);
            Node r = curr.random;
            temp.next.random = r == null ? null : map.get(r);
            temp = temp.next;
            curr = curr.next;
        }
        return ans.next;
    }
}
