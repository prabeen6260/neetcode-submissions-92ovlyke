class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)sum+=nums[i];
        if(sum%2!=0)return false;
        int required = sum/2;
        boolean[] dp=new boolean[required+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=required;j>=nums[i];j--){
                dp[j]=dp[j]||dp[j-nums[i]];
                if(dp[required])return true;
            }
        }
        return dp[required];
    }
}
