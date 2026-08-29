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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;

        ListNode right = reverse(newHead);
        ListNode left=head;

        while(left!=null && right!=null){
            ListNode temp1=left.next;
            ListNode temp2=right.next;

            left.next=right;
            right.next=temp1;

            left=temp1;
            right=temp2;
        }

    }
    public ListNode reverse(ListNode newHead){
        ListNode curr=newHead;
        ListNode prev=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}