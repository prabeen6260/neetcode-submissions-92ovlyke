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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = new ListNode();
        current=head;
        int size=0;
        while(current!=null){
            size++;
            current=current.next;
        }
        int index=size-n;
        int count=0;
        ListNode dummy = new ListNode();
        dummy.next=head;
        current=dummy;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        current.next=current.next.next;
        return dummy.next;
    }
}
