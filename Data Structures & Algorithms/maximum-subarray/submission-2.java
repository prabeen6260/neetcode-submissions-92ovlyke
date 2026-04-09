class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int currSum=nums[0];
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(currSum<0){
                currSum=nums[i];
            }
            else currSum+=nums[i];
            max=Math.max(currSum,max);
        }
        return max;
    }
}
