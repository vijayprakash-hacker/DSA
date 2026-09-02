/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(-5001);

        while (head != null) {
            ListNode prev = null;
            ListNode curr = newHead;

            while (true) {
                if (curr == null) {
                    prev.next = head;
                    head = head.next;
                    prev.next.next = null;
                    break;
                } else if (curr.val > head.val) {
                    ListNode temp = head;
                    head = head.next;
                    temp.next = curr;
                    prev.next = temp;
                    break;
                }

                prev = curr;
                curr = curr.next;
            }

        }

        return newHead.next;
    }
}