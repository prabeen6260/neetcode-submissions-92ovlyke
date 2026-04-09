class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0)return 0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int curr=0;
        int count=0;
        for(int num:nums){
            curr+=num;
            if(map.containsKey(curr-k)){
                count+=map.getOrDefault(curr-k,0);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return count;
    }
}