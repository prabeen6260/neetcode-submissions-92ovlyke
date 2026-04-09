class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        list=new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        if(list.size()==1)return 1;
        int count=0;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)<=price){
                count++;
            }
            else return count;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */