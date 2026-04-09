class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int currMax=nums[0];
        int currMin=nums[0];
        int max=nums[0];
        int min=nums[0];
        int total=nums[0];
        for(int i=1;i<n;i++){
            total+=nums[i];
            currMax=Math.max(nums[i],currMax+nums[i]);
            currMin=Math.min(nums[i],currMin+nums[i]);
            max=Math.max(max,currMax);
            min=Math.min(min,currMin);
        }
        return total-min==0?max:Math.max(max,total-min);
    }
}