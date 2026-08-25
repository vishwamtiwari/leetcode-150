class Solution {
public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head.next == null || left == right) return head;

    int n = 1;
    ListNode dummy = new ListNode(0, head);
    ListNode preLeft = dummy;

    for (int i = 0; i < left - 1; i++) {
        preLeft = preLeft.next;
    }

    ListNode current = preLeft.next;
    ListNode prev = null;
    n = left;
    while (n <= right) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        n++;
    }

    preLeft.next.next = current;
    preLeft.next = prev;

    return dummy.next;
}
}