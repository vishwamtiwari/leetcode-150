class Solution {
    public Node copyRandomList(Node head) {
//        Approach 1: worst case space complexity O(n) due to the hashmap;
//        if (head == null)
//            return null;
//
//        Map<Node, Node> map = new HashMap<>();
//
//        Node current = head;
//        Node prev = null;
//        Node newHead = null;
//
//        while (current != null) {
//            Node temp = new Node(current.val);
//
//            //mapping new node in the deep copy to corresponding node in original
//            map.put(current, temp);
//
//            if (newHead == null) {
//                newHead = temp;
//                prev = newHead;
//            } else {
//                prev.next = temp;
//                prev = temp;
//            }
//
//            current = current.next;
//        }
//
//        //fill random pointers
//        current = head;
//        Node newCurrent = newHead;
//
//        while (current != null) {
//            if (current.random == null) {
//                newCurrent.random = null;
//            } else {
//                newCurrent.random = map.get(current.random);
//            }
//            current = current.next;
//            newCurrent = newCurrent.next;
//        }
//
//        return newHead;


//      Approach 2: takes no extra space apart from the output which is excluded, hence space complexity is O(1)
        if (head == null)
            return null;

        //Inserting new/copy nodes in between the original linked list
        Node current = head;

        while (current != null) {
            Node currNext = current.next;
            current.next = new Node(current.val);
            current.next.next = currNext;

            current = currNext;
        }

        //Copying the random pointers
        current = head;
        while (current != null && current.next != null) {
            if (current.random == null) {
                current.next.random = null;
            } else {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        //Separate the linked list to get just the copy;
        current = head;
        Node newHead = head.next;
        Node newCurrent = newHead;

        while (current != null && newCurrent != null) {
            current.next = (current.next == null) ? null : current.next.next;
            newCurrent.next = (newCurrent.next == null) ? null: newCurrent.next.next;

            current = current.next;
            newCurrent = newCurrent.next;
        }

        return newHead;
    }
}