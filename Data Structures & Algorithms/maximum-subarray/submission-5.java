class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int local = nums[n-1];
        int global = nums[n-1];
        for(int i=n-2;i>=0;i--){
            local=Math.max(nums[i],nums[i]+local);
            global=Math.max(local,global);

        }
        return global;
    }
}
