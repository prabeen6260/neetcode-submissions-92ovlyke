class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1=text1.length();
        int t2=text2.length();
        if(t1>t2)return longestCommonSubsequence(text2,text1);
        int[] dp=new int[t2+1];
        for(int i=1;i<=t1;i++){
            int prev=dp[0];
            for(int j=1;j<=t2;j++){
                int temp=dp[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[j]=1+prev;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                prev=temp;
            }
            
        }
        return dp[t2];
    }
}
