class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y= points[i][1];
            int d = x*x + y*y;
            pq.offer(new int[]{d,i});
            if(pq.size()>k)pq.poll();
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=points[pq.poll()[1]];
        }
        return ans;
    }
}
