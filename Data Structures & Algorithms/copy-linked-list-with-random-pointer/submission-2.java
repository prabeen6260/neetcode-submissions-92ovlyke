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
        Map<Node,Node> map =new HashMap<>();
        Node curr=head;
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        Node curr2=head;
        while(curr2!=null){
            map.get(curr2).next=map.get(curr2.next);
            map.get(curr2).random=map.get(curr2.random);
            curr2=curr2.next;
        }
        return map.get(head);
    }
}
