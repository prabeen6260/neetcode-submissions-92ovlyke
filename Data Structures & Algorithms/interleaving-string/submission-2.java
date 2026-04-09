class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 + n2 != s3.length()) return false;

        // dp[j] represents the result for s1.substring(0, i) and s2.substring(0, j)
        boolean[] dp = new boolean[n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) {
                    // Base case: empty strings match
                    dp[j] = true;
                } else if (i == 0) {
                    // First row: only using characters from s2
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    // First column: only using characters from s1
                    // Current dp[0] is the result from the previous row (i-1)
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    // Inner cells: can come from top (s1) or left (s2)
                    // (dp[j] is "top", dp[j-1] is "left")
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
                            (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[n2];
    }
}