class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[][] effort=new int[m][n];
        for(int[] row:effort)Arrays.fill(row,Integer.MAX_VALUE);
        effort[0][0]=0;
        pq.offer(new int[]{0,0,effort[0][0]});
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            int r=val[0];
            int c=val[1];
            int e=val[2];
            if(e>effort[r][c])continue;
            if(r==m-1 && c==n-1)return e;
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int eff=Math.max(e,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(eff<effort[nr][nc]){
                        effort[nr][nc]=eff;
                        pq.offer(new int[]{nr,nc,eff});
                    }
                }
            }
        }
        return pq.peek()[2];
    }
}