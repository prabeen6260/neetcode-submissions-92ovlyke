class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)map.computeIfAbsent(nums[i],s->new ArrayList<>()).add(i);
        for(List<Integer> list:map.values()){
            if(list.size()>1){
                for(int i=1;i<list.size();i++){
                    int num=Math.abs(list.get((i-1))-list.get(i));
                    if(num<=k)return true;
                }
            }
        }
        return false;
    }
}