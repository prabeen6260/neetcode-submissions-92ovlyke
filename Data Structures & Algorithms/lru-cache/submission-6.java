class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int value;
        Node(){};
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            moveToHead(node);
            return;
        }
        Node node=new Node(key,value);
        map.put(key,node);
        addToHead(node);
        if(map.size()>capacity){
            Node tail=removeTail();
            map.remove(tail.key);
        }
        return;
    }
    private void addToHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
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
