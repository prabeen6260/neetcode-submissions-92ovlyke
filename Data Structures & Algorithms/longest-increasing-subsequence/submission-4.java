class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    int newMax = 1+dp[j];
                    dp[i]=Math.max(dp[i],newMax);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
}
