class Solution {
    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = reverse(head);
        ListNode curr = temp;
        int max = curr.val;

        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } else {
                max = curr.next.val;
                curr = curr.next;

            }
        }
        
        head = reverse(temp);
        return head;
    }
}