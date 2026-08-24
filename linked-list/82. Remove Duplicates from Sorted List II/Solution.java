class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            //Checking if a duplicate sequence starts
            if (head.next != null && head.val == head.next.val) {
                //Moving forward to the last node of the duplicate sequence
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                //bypassing all the nodes of the duplicate sequence
                prev.next = head.next;
            } else {
                //No duplicate found -  can move to the next node
                prev = prev.next;
            }
            //Moving to the next candidate
            head = head.next;
        }
        return dummy.next;
    }
}