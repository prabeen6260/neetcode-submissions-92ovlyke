class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        if(s.charAt(n-1)=='1')return false;
        char[] c=s.toCharArray();
        boolean[] dp=new boolean[s.length()];
        dp[0]=true;
        int count=0;
        for(int x=1;x<s.length();x++){
            if(x>=minJump && dp[x-minJump]){
                count++;
            }
            if(x-maxJump-1>=0 && dp[x-maxJump-1]){
                count--;
            }
            if(count>0 && c[x]=='0'){
                if (x == n - 1) return true;
                dp[x]=true;
            }
        }
        return dp[s.length()-1];
    }
}