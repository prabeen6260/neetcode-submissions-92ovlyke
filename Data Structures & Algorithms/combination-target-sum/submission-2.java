class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums,target,0,new ArrayList<>());
        return ans;
    }
    private void backtrack(int[] nums, int target,int start,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i]>target)break;
            list.add(nums[i]);
            backtrack(nums,target-nums[i],i,list);
            list.remove(list.size()-1);
        }
    }
}
