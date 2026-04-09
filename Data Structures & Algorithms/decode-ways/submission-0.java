class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        int[] dp= new int[s.length()+1];
        dp[0]=1;
        for(int i=1;i<=s.length();i++){
            if(s.charAt(i-1)-'0'>0 && s.charAt(i-1)-'0'<10){
                dp[i]=dp[i-1];
            }
            int value=0;
            if(i-2>=0)value = (s.charAt(i-2)-'0')*10+ (s.charAt(i-1)-'0');
            if(value>=10 && value<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
