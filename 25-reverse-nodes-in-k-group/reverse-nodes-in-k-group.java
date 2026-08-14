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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        ListNode curr = head;
        ListNode prevGroupEnd = null;

        while (true) {

            // Check if k nodes are available
            ListNode temp = curr;

            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    return head;
                }
                temp = temp.next;
            }

            // Save the start of this group
            ListNode groupStart = curr;

            // Reverse this group
            ListNode prev = null;
            ListNode next;

            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group to current reversed group
            if (prevGroupEnd != null) {
                prevGroupEnd.next = prev;
            } else {
                // First group becomes the new head
                head = prev;
            }

            // groupStart is now the end of the reversed group
            groupStart.next = curr;

            // Update previous group end
            prevGroupEnd = groupStart;
        }
    }
}