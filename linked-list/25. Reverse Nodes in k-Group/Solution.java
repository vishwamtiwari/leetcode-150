class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;

        //chcek if k nodes exist
        while (count < k) {
            if (temp == null)
                return head;

            temp = temp.next;

            count++;
        }

        //recursively calling for rest of the linked list
        ListNode prevNode = reverseKGroup(temp, k);

        //reverse current k group
        temp = head;
        count = 0;

        while (count < k) {
            ListNode next = temp.next;
            temp.next = prevNode;

            prevNode = temp;
            temp = next;

            count++;
        }

        return prevNode;
    }
}