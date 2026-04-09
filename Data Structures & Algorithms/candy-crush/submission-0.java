class Solution {
    public int[][] candyCrush(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean found=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=Math.abs(board[i][j]);
                if(val!=0 && j<n-2 && val==Math.abs(board[i][j+1]) && val==Math.abs(board[i][j+2])){
                    board[i][j+1]=board[i][j+2]=board[i][j]=-val;
                    found=true;
                }
                if(val!=0 && i<m-2 && val==Math.abs(board[i+1][j]) && val==Math.abs(board[i+2][j])){
                    board[i+1][j]=board[i+2][j]=board[i][j]=-val;
                    found=true;
                }
            }
        }
        if(found){
            for(int j=0;j<n;j++){
            int point=m-1;
            for(int i=m-1;i>=0;i--){
                if(board[i][j]>0){
                    board[point][j]=board[i][j];
                    point--;
                }
            }
            while(point>=0){
                board[point][j]=0;
                point--;
                }
            }
            return candyCrush(board);
        }
        return board;
    }
}
