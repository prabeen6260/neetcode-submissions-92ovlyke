class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j){
        Deque<int[]> q= new ArrayDeque<>();
        grid[i][j]='0';
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row=node[0];
            int col=node[1];
            for(int[] dir: dirs){
                int r=row+dir[0];
                int c=col+dir[1];
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
                    q.offer(new int[]{r,c});
                    grid[r][c]='0';

                }
            }
        }
        return;
    }
}
