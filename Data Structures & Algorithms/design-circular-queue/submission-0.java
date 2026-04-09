class MyCircularQueue {
    List<Integer> q;
    int k;
    public MyCircularQueue(int k) {
        q=new ArrayList<>(k);
        this.k=k;
    }
    
    public boolean enQueue(int value) {
        if(q.size()>=k)return false;
        q.add(value);
        return true;
    }
    
    public boolean deQueue() {
        if(q.size()>0){
            int temp=0;
            for(int i=0;i<q.size()-1;i++){
                q.set(i,q.get(i+1));
                temp=i+1;
            }
            q.remove(q.get(temp));
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(q.size()>0){
            return q.get(0);
        }
        return -1;
    }
    
    public int Rear() {
        if(q.size()>0){
            for(int i=q.size()-1;i>=0;i--){
                if(q.get(i)!=null){
                    return q.get(i);
                }
            }
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if(q.size()==0)return true;
        return false;
    }
    
    public boolean isFull() {
        if(q.size()==k)return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */