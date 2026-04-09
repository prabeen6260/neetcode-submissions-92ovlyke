class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums)set.add(n);
        int ans =0;
        for(int num:set){
            if(!set.contains(num-1)){
                int start = num;
                int count=1;
                while(set.contains(start+1)){
                    count++;
                    start++;
                }
                ans=Math.max(ans,count);
            }

        }
        return ans;
    }
}
