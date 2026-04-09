class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        // Priority Queue stores {row, col, current_max_effort}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            
            // If we reached the end, this is our minimum effort
            if (r == m - 1 && c == n - 1) return d;
            
            if (d > dist[r][c]) continue;
            
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    // The effort to this neighbor is the max of the path so far 
                    // and the absolute difference between these two cells
                    int newEffort = Math.max(d, Math.abs(heights[r][c] - heights[nr][nc]));
                    
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}