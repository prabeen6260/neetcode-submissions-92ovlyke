class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(){};
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node =map.get(key);
            node.val=value;
            moveToHead(node);
            return;
        }
        Node node=new Node(key,value);
        map.put(key,node);
        addToHead(node);
        if(map.size()>capacity){
            Node tail = removeTail();
            map.remove(tail.key);
        }
        return;
    }
    private void addToHead(Node node){
        head.next.prev=node;
        node.next=head.next;
        node.prev=head;
        head.next=node;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private Node removeTail(){
        Node node =tail.prev;
        removeNode(node);
        return node;
    }

}
