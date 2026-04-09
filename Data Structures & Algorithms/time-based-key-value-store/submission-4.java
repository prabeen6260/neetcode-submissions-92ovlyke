class TimeMap {
    class Obj{
        int timestamp;
        String value;
        Obj(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    Map<String,Deque<Obj>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayDeque<>()).push(new Obj(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            for(Obj obj:map.get(key)){
                if(obj.timestamp<=timestamp){
                    return obj.value;
                }
            }
        }
        return "";
    }
}
