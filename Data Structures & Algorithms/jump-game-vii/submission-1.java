class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] c=s.toCharArray();
        boolean[] dp=new boolean[s.length()];
        dp[0]=true;
        int count=0;
        for(int x=minJump;x<s.length();x++){
            if(dp[x-minJump]){
                count++;
            }
            if(x-maxJump-1>=0 && dp[x-maxJump-1]){
                count--;
            }
            if(count>0 && c[x]=='0'){
                dp[x]=true;
            }
        }
        return dp[s.length()-1];
    }
}