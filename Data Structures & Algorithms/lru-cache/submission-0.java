class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
            addToFront(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node n = new Node (key,value);

        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.val = value;
            removeNode(curr);
            addToFront(curr);
        } else {
            if(map.size() >= capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                map.put(key, n);
                addToFront(n);
            } else {
                addToFront(n);
                map.put(key, n);
            }
        }
    }
    public void removeNode(Node n){
        Node next = n.next;
        Node prev = n.prev;
        n.next = null;
        n.prev = null;
        prev.next = next;
        next.prev = prev;
    }
    public void addToFront(Node n){
        Node temp = head.next;
        head.next = n;
        n.next = temp;
        n.prev = head;
        temp.prev = n;
    }
}
