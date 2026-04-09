class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum1=Integer.MIN_VALUE;
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=nums[i];
            sum1=Math.max(sum1,curr);
            if(curr<0){
                curr=0;
            }
        }
        curr=0;
        int total=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            total+=nums[i];
            curr+=nums[i];
            min=Math.min(min,curr);
            if(curr>0){
                curr=0;
            }
        }
        if(total-min==0)return sum1;
        return Math.max(sum1,total-min);
    }
}