class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int l=0;
        int len=n;
        int curr=0;
        int total=0;
        for(int r=0;r<n;r++){
            total+=nums[r];
            curr+=nums[r];
            while(curr>=target){
                len=Math.min(len,r-l+1);
                curr-=nums[l];
                l++;
            }
        }
        return total<target?0:len;
    }
}