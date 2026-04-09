class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,bfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    private int bfs(int[][] grid,int i,int j){
        Deque<int[]> q=new ArrayDeque<>();
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        q.offer(new int[]{i,j});
        grid[i][j]=0;
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] val= q.poll();
                int r=val[0];
                int c=val[1];
                for(int[] dir:dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc]=0;
                        ans++;
                        q.offer(new int[]{nr,nc});                    }
                }
            }
        }
        return ans;
    }
}
