class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m= heights.length;
        int n=heights[0].length;
        boolean[][] pacific = new boolean [m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
            dfs(heights,i,n-1,atlantic);
        }
        for(int j=0;j<n;j++){
            dfs(heights,0,j,pacific);
            dfs(heights,m-1,j,atlantic);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    private void dfs(int [][] grid,int r, int c, boolean[][] flag){
        flag[r][c]=true;
        for(int[] dir:dirs){
            int rd=r+dir[0];
            int cd=c+dir[1];
            if(rd>=0 && cd>=0 && rd<grid.length && cd<grid[0].length && grid[rd][cd]>=grid[r][c] && !flag[rd][cd]){
                dfs(grid,rd,cd,flag);
            }
        }
    }
}
