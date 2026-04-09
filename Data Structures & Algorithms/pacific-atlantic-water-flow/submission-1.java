class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            pacific[i][0]=true;
            bfs(heights,pacific,i,0);
            atlantic[i][n-1]=true;
            bfs(heights,atlantic,i,n-1);
        }
        for(int j=0;j<n;j++){
            pacific[0][j]=true;
            bfs(heights,pacific,0,j);
            atlantic[m-1][j]=true;
            bfs(heights,atlantic,m-1,j);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    private void bfs(int[][] heights,boolean[][] check,int i,int j){
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] val = q.poll();
            int r=val[0];
            int c=val[1];
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && heights[nr][nc]>=heights[r][c] && !check[nr][nc]){
                    q.add(new int[]{nr,nc});
                    check[nr][nc]=true;
                }
            }
        }
    }
}
