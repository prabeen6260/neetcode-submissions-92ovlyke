class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=nums[i];
            int target=curr-k;
            if(map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return count;
    }
}