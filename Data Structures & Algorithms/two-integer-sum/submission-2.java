class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>();
        int [] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int diff = target - num;
            if(seen.containsKey(diff)){
                ans[0]=seen.get(diff);
                ans[1]=i;
                return ans;
            }
            seen.put(num,i);

        }
        return new int[]{-1,-1};
        
    }
}
