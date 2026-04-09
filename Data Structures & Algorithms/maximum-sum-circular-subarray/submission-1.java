class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int curr=nums[0];
        int max=nums[0];
        int min=0;
        for(int i=1;i<nums.length;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            min=Math.min(nums[i],min+nums[i]);
            max=Math.max(max,curr);
            max=Math.max(max,sum-min);
        }
        return max;
    }
}