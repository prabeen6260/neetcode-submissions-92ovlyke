class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int currMax=0;
        int currMin=0;
        int max=nums[0];
        int min=nums[0];
        for(int num:nums){
            totalSum+=num;

            currMax=Math.max(num,currMax+num);
            max=Math.max(max,currMax);

            currMin=Math.min(num,num+currMin);
            min=Math.min(min,currMin);
        }
        if(max<0)return max;
        return Math.max(max,totalSum-min);
    }
}