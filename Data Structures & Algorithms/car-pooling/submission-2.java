class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n= trips.length;
        int[] roadEvent=new int[10001];
        if(n==1){
            if(trips[0][0]>capacity)return false;
        }
        int currCapacity=0;
        for(int[] trip:trips){
           int numPass=trip[0];
           int start=trip[1];
           int end=trip[2];
           for(int i=start;i<end;i++){
                roadEvent[i]+=numPass;
                if(roadEvent[i]>capacity)return false;
           }
        }
        return true;
    }
}