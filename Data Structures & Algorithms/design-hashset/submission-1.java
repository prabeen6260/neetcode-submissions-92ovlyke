class MyHashSet {
    int BUCKET=10000;
    List<Integer>[] list;
    public MyHashSet() {
        list=new LinkedList[BUCKET];
    }
    private int hash(int key){
        return Math.abs(key)%BUCKET;
    }

    public void add(int key) {
        int indx=hash(key);
        if(list[indx]==null)list[indx]=new LinkedList<>();
        if(!contains(key))list[indx].add(key);
    }
    
    public void remove(int key) {
        int indx=hash(key);
        if(list[indx]!=null)list[indx].remove((Integer)key);
    }
    
    public boolean contains(int key){
        int indx=hash(key);
        if(list[indx]==null)return false;
        return list[indx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */