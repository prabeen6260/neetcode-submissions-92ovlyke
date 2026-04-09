class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] map = new int[n][2];
        for(int i=0;i<n;i++){
            map[i][0]=position[i];
            map[i][1]=speed[i];
        }
        Arrays.sort(map,(a,b)->b[0]-a[0]);
        Deque<Double> ans=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            double time= (double)(target-map[i][0])/map[i][1];
            if(ans.isEmpty())ans.push(time);
            else if(time<=ans.peek())continue;
            else ans.push(time);
        }
        return ans.size();
    }
}
