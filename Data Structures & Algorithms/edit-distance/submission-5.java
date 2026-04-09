class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[] dp=new int[n2+1];
        for(int j=1;j<=n2;j++)dp[j]=j;

        for(int i=1;i<=n1;i++){
            int prev=dp[0];
            dp[0]=i;
            for(int j=1;j<=n2;j++){
                int temp=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[j]=prev;
                }
                else{
                    dp[j]=1+Math.min(prev,Math.min(dp[j],dp[j-1]));
                }
                prev=temp;
            }
        }
        return dp[n2];
    }
}
