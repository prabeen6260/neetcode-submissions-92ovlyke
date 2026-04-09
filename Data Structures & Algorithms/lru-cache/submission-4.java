class LRUCache {
    public class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(){};
        Node(int k, int v){
            key=k;
            val=v;
        }
    }
    Map<Integer,Node> store;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        store = new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(store.containsKey(key)){
            Node node = store.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(store.containsKey(key)){
            Node node =store.get(key);
            node.val=value;
            moveToHead(node);
        }
        else{
            Node node = new Node(key,value);
            store.put(key,node);
            addToHead(node);
            if(store.size()>capacity){
                Node tail = removeTail();
                store.remove(tail.key);
            }
        }
    }
    private void addToHead(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private Node removeTail(){
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

}
