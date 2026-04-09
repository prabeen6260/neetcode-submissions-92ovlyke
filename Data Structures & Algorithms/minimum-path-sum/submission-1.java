class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[j]=grid[i][j]+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}