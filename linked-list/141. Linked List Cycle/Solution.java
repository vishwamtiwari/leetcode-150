public class Solution {
    public boolean hasCycle(ListNode head) {
        //floyd's tortoise and hare algorithm
        if (head == null || (head != null && head.next == null)) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}