class Solution {
    long inf = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j,0);
                }
            }
        }
    }
    private void dfs(int[][] grid,int i,int j,int distance){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return;
        }
        if(grid[i][j]<distance)return;
        grid[i][j]=Math.min(grid[i][j],distance);
        dfs(grid,i+1,j,distance+1);
        dfs(grid,i-1,j,distance+1);
        dfs(grid,i,j+1,distance+1);
        dfs(grid,i,j-1,distance+1);
        return;
    }
}
