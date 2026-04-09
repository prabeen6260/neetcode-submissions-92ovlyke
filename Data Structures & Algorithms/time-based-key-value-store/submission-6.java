class TimeMap {
    class Obj{
        int timestamp;
        String value;
        Obj(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    Map<String,List<Obj>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new Obj(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        List<Obj> list=map.get(key);
        if(list.get(0).timestamp>timestamp)return "";
        int l=0;
        int r=list.size()-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid).timestamp<=timestamp){
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans==-1?"":list.get(ans).value;
    }
}
