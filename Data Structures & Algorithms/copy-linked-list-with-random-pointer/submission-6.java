/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node curr=head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next=new Node(curr.val);
            curr=curr.next;
            curr.next=temp;
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
                curr=curr.next.next;
            }
            else{
                curr.next.random=null;
                curr=curr.next.next;
            }
        }
        curr=head;
        Node copyHead=curr.next;
        Node copy=copyHead;
        curr.next=curr.next.next;
        curr=curr.next;
        while(curr!=null){
            copyHead.next=curr.next;
            copyHead=copyHead.next;
            curr.next=curr.next.next;
            curr=curr.next;
        }
        return copy;
    }
}
