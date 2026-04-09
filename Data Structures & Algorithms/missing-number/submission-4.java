class Solution {
    public int missingNumber(int[] nums) {
        int required=0;
        int given=0;
        for(int i=1;i<=nums.length;i++){
            required+=i;
            given+=nums[i-1];
        }
        return required-given;
    }
}
