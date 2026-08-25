class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        int i = 0;
        while (i <= n) {
            fast = fast.next;
            i++;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

            if (fast == null) {
                break;
            }
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}