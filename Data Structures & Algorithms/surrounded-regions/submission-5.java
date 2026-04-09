class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                board[i][0]='T';
            }
            if(board[i][n-1]=='O'){
                board[i][n-1]='T';
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                board[0][j]='T';
            }
            if(board[m-1][j]=='O'){
                board[m-1][j]='T';
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='T'){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(char[][] grid, int r, int c){
        for(int[] dir:dirs){
            int rd= r+dir[0];
            int cd=c+dir[1];
            if(rd>=0 && cd>=0 && rd<grid.length && cd<grid[0].length && grid[rd][cd]=='O'){
                grid[rd][cd]='T';
                dfs(grid,rd,cd);
            }
        }
    }
}
