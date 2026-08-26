class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            Node prevNode = temp.prev;
            Node nextNode = temp.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            Node firstNode = head.next;
            temp.prev = head;
            temp.next = firstNode;

            head.next = temp;
            firstNode.prev = temp;

            return temp.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node updatedNode = map.get(key);
            updatedNode.val = value;

            map.put(key, updatedNode);

            updatedNode.prev.next = updatedNode.next;
            updatedNode.next.prev = updatedNode.prev;

            Node firstNode = head.next;
            updatedNode.next = firstNode;
            updatedNode.prev = head;
            firstNode.prev = updatedNode;
            head.next = updatedNode;
        } else {
            if (map.size() == capacity) {
                Node lru = map.get(tail.prev.key);

                map.remove(lru.key);

                lru.prev.next = tail;
                tail.prev = lru.prev;
            }

            Node newNode = new Node(key, value);

            map.put(key, newNode);

            newNode.next = head.next;
            newNode.prev = head;
            head.next.prev = newNode;
            head.next = newNode;
        }
    }
}