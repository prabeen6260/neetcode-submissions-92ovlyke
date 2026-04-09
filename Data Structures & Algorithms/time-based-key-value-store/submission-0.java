class TimeMap {
    class Data{
        int time;
        String val;
        Data(String value,int timestamp){
            val=value;
            time=timestamp;
        }
    }
    Map<String,List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        else{
            List<Data> list = map.get(key);
            int l=0;
            int r=list.size()-1;
            String ans="";
            while(l<=r){
                int mid =l+(r-l)/2;
                if(list.get(mid).time<=timestamp){
                    ans = list.get(mid).val;
                    l=mid+1;
                }
                else r=mid-1;
            }
            return ans;
        }
    }
}
