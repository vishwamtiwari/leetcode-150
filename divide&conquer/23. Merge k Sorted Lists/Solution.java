class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return divideAndConquer(lists, 0, lists.length - 1);
    }

    ListNode divideAndConquer(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];

        int mid = left + (right - left) / 2;

        ListNode first = divideAndConquer(lists, left, mid);
        ListNode second = divideAndConquer(lists, mid + 1, right);

        return mergeTwoLists(first, second);
    }

    ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (first != null && second != null) {
            int val1 = first.val;
            int val2 = second.val;

            if (val1 > val2) {
                current.next = second;
                second = second.next;
            } else {
                current.next = first;
                first = first.next;
            }

            current = current.next;
        }

        current.next = (first != null) ? first : second;

        return dummy.next;
    }
}