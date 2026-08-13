/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        int length = 0;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                length = lengthCycle(slow);
                break;
            }
        }

        // No cycle
        if (length == 0) {
            return null;
        }

        // Step 2: Keep two pointers at head
        ListNode s = head;
        ListNode f = head;

        // Move one pointer ahead by cycle length
        while (length > 0) {
            s = s.next;
            length--;
        }

        // Step 3: Move both until they meet
        while (s != f) {
            s = s.next;
            f = f.next;
        }

        return s;
    }

    public int lengthCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode temp = slow;
                int length = 0;

                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                return length;
            }
        }

        return -1;
    }
}