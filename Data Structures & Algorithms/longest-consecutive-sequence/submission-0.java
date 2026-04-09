class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums)set.add(n);
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int start = nums[i];
                int count=1;
                while(set.contains(start+1)){
                    count++;
                    start=start+1;
                }
                ans=Math.max(ans,count);
            }

        }
        return ans;
    }
}
