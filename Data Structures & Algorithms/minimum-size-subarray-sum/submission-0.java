class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int ans=n+1;
        int l=0;
        int sum=0;
        int totalSum=0;
        for(int r=0;r<n;r++){
            totalSum+=nums[r];
            sum+=nums[r];
            while(sum>=target){
                ans=Math.min(ans,r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return totalSum<target?0:ans;
    }
}