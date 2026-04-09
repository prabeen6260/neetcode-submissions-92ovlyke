class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        while (true) {
            boolean found = false;
            
            // 1. Marking Phase 🚩
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;
                    
                    // Check horizontal matches ↔️
                    if (j < n - 2 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                        found = true;
                    }
                    
                    // Check vertical matches ↕️
                    if (i < m - 2 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                        board[i][j] = board[i + 1][j] = board[i + 2][j] = -val;
                        found = true;
                    }
                }
            }
            
            // If no new matches are found, the board is stable 🛑
            if (!found) break;

            // 2. Gravity / Drop Phase 🍎
            for (int j = 0; j < n; j++) {
                int point = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] > 0) {
                        board[point--][j] = board[i][j];
                    }
                }
                // Fill the top remaining spaces with empty 0s 🕳️
                while (point >= 0) {
                    board[point--][j] = 0;
                }
            }
        }
        return board;
    }
}