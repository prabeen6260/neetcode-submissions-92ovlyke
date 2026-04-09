class Solution {
    long inf =2147483647;
    int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        bfs(grid,q);
    }
    private void bfs(int[][] grid,Deque<int[]> q){
        while(!q.isEmpty()){
            int[]node = q.poll();
            int r=node[0];
            int c=node[1];
            for(int[] dir:dirs){
                int rd=r+dir[0];
                int cd=c+dir[1];
                if(rd>=0 && cd>=0 && rd<grid.length && cd<grid[0].length && grid[rd][cd]==inf){
                    grid[rd][cd]=grid[r][c]+1;
                    q.offer(new int[]{rd,cd});
                }
            }
        }
    }
}
