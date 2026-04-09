class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        // Use a 1D array to store the current row's distances
        int[] dp = new int[n2 + 1];
        
        // Base case: transforming an empty word1 into word2 (insertions)
        for (int j = 0; j <= n2; j++) {
            dp[j] = j;
        }
        
        for (int i = 1; i <= n1; i++) {
            // prev stores the diagonal value (dp[i-1][j-1])
            int prev = dp[0]; 
            // Base case: transforming word1 into an empty word2 (deletions)
            dp[0] = i; 
            
            for (int j = 1; j <= n2; j++) {
                int temp = dp[j]; // Store current value before overwriting
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match: no cost, take the diagonal value
                    dp[j] = prev;
                } else {
                    // Characters differ: 1 + min(Insert, Delete, Replace)
                    // dp[j-1] is Left (Insert), dp[j] is Top (Delete), prev is Diagonal (Replace)
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }
                // The current value (before update) becomes the 'prev' for next j
                prev = temp;
            }
        }
        
        return dp[n2];
    }
}