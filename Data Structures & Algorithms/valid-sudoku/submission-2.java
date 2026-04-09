class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> col = new ArrayList<>();
        List<Set<Character>> box = new ArrayList<>();
        for(int i=0;i<n;i++){
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char val = board[i][j];
                if(val=='.')continue;
                if(!row.get(i).add(val)) return false;
                if(!col.get(j).add(val)) return false;
                int index=(i/3)*3+(j/3);
                if(!box.get(index).add(val))return false;
            }
        }
        return true;

        
    }
}
