class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        for(int i=0;i<nums.length;i++){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast)break;
        }
        int slow2=0;
        for(int i=0;i<nums.length-1;i++){
            slow=nums[slow];
            slow2=nums[slow2];
            if(slow==slow2)return slow;
        }
        return -1;
    }
}
