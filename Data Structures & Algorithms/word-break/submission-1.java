class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen=0;
        for(String word:wordSet)maxLen=Math.max(maxLen,word.length());
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            int jStart=Math.max(0,i-maxLen);
            for(int j=i;j>=jStart;j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
        
    }
}
