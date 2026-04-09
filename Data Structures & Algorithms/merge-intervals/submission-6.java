class Solution {
    public int[][] merge(int[][] intervals) {
        // empty arrys
        if(intervals.length==0)return new int[0][0];
        if(intervals.length==1)return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int[] last=list.get(list.size()-1);
            if(last[1]>=intervals[i][0]){
                list.set(list.size()-1,new int[]{last[0],Math.max(last[1],intervals[i][1])});
            }
            else {
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
