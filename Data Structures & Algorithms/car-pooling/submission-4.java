class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n= trips.length;
        int[] roadEvent=new int[1001];
        int currCapacity=0;
        for(int[] trip:trips){
           int numPass=trip[0];
           int start=trip[1];
           int end=trip[2];
           roadEvent[start]+=numPass;
           roadEvent[end]-=numPass;
        }
        for (int i = 0; i < roadEvent.length; i++) {
            currCapacity += roadEvent[i];
            if(currCapacity>capacity)return false;
        }
        return true;
    }
}