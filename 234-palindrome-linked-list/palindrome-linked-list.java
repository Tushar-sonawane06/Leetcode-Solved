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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);
        ListNode nxtMid=mid.next;
        mid.next=null;

        nxtMid = reverse(nxtMid);

        while(nxtMid!=null){
            if(head.val!=nxtMid.val){
                return false;
            }
            head=head.next;
            nxtMid=nxtMid.next;
        }

        return true;
    }

    public ListNode reverse(ListNode nxtMid){
        ListNode curr=nxtMid;
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

    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}