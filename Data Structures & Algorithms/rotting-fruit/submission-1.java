class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)count++;
            }
        }
        return bfs(grid,q,count);
    }
    private int bfs(int[][] grid, Deque<int[]>q,int count){
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int check=count;
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int r=node[0];
                int c=node[1];
                for(int[] dir:dirs){
                    int rd=r+dir[0];
                    int cd=c+dir[1];
                    if(rd>=0 && cd>=0 && rd<grid.length && cd<grid[0].length && grid[rd][cd]==1){
                        grid[rd][cd]=2;
                        q.offer(new int[]{rd,cd});
                        count-=1;
                    }
                }
            }
            if(check!=count){
                ans++;
            }
        }
        return count!=0?-1:ans;
        
    }
}
