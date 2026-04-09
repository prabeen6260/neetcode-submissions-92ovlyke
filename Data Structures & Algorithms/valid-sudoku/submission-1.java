class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> row= new HashSet<>();
            Set<Character> col= new HashSet<>();
            Set<Character> sub= new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!row.add(board[i][j]))return false;
                }
                if(board[j][i]!='.'){
                    if(!col.add(board[j][i]))return false;
                }
                int sub_i = (i/3)*3 + (j/3);
                int sub_j = (i%3)*3 + (j%3);
                if(board[sub_i][sub_j]!='.'){
                    if(!sub.add(board[sub_i][sub_j]))return false;
                }
            }
        }
        return true;
    }
}
