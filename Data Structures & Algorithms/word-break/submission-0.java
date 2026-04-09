class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen=0;
        for(String word:dict)maxLen=Math.max(maxLen,word.length());
        dp[0]=true;
        for(int i=1;i<=n;i++){
            int jStart=Math.max(0,i-maxLen);
            for(int j=i;j>=jStart;j--){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[n];

    }
}
