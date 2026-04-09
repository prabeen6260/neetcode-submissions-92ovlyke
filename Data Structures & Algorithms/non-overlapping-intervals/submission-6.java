class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1)return 0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int endTime =intervals[0][1];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<endTime){
                ans++;
            }
            else{
                endTime=intervals[i][1];
            }
        }
        return ans;
    }
}
