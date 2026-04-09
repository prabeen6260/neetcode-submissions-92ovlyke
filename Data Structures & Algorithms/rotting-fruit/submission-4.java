class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> q=new ArrayDeque<>();
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)fresh++;
            }
        }
        int min=0;
        int curr=fresh;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] val=q.poll();
                int r=val[0];
                int c=val[1];
                for(int[] dir:dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                        curr--;
                    }
                }
            }
            if(curr!=fresh){
                min++;
                fresh=curr;
            }
        }
        return fresh==0?min:-1;
    }
}
