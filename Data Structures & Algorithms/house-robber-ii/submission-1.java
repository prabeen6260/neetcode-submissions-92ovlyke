class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int prev2=nums[0];
        int prev1=Math.max(prev2,nums[1]);
        for(int i=2;i<n-1;i++){
            int current=Math.max(prev1,prev2+nums[i]);

            prev2=prev1;
            prev1=current;
        }
        int prev4=nums[1];
        int prev3=Math.max(nums[2],prev4);
        for(int j=3;j<n;j++){
            int current=Math.max(prev3,nums[j]+prev4);

            prev4=prev3;
            prev3=current;
        }
        return Math.max(prev1,prev3);
    }
}
