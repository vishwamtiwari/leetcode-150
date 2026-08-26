class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smallerDummy = new ListNode(0);
        ListNode greterDummy = new ListNode(0);
        ListNode smaller = smallerDummy;
        ListNode greater = greterDummy;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        smaller.next = greterDummy.next;

        return smallerDummy.next;
    }
}