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
        ListNode dummy= new ListNode();
        dummy.next=head;
        ListNode curr=dummy;
        int size=-1;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        curr=dummy;
        int newN=size-n;
        for(int i=0;i<size;i++){
            if(i==newN){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}
