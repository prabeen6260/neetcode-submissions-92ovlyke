class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m =grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int count = dfs(grid,i,j);
                    ans=Math.max(count,ans);
                }
            }
        }
        return ans;
    }
    private int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=0;
        int count=dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1)+1;
        return count;
    }
}
