class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dirs=new int[][]{{1,0},{0,1}};
        int m=grid.length;
        int n=grid[0].length;
        int[][] sum=new int[m][n];
        for(int[] r:sum){
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty()){
            int[] all = pq.poll();
            int r=all[0];
            int c=all[1];
            int s=all[2];
            if(r==m-1 && c==n-1)return s;
            if(sum[r][c]<s)continue;
            for(int[] d:dirs){
                int nr= r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newS= s+grid[nr][nc];
                    if(newS<sum[nr][nc]){
                        sum[nr][nc]=newS;
                        pq.add(new int[]{nr,nc,newS});
                    }
                }
            }
        }
        return 0;
    }
}