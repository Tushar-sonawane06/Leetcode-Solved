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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        temp.next=head;

        int rot=k%length;
        int skip=length-rot;
        
        ListNode lastNode=head;
        for(int i=1;i<skip;i++){
            lastNode=lastNode.next;
        }

        head=lastNode.next;
        lastNode.next=null;

        return head;

    }
}