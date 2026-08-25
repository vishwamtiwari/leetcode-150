class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len ++;
        }
        k %= len;

        if (k == 0) return head;

        temp.next = head;
        ListNode current = head;
        for (int i = 0; i < len - k - 1; i++) {
            current = current.next;
        }

        head = current.next;
        current.next = null;

        return head;
    }
}