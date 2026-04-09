class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(int[] nums, int target, int index, List<Integer>list,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i-1]==nums[i])continue;
            if(nums[i]>target)break;
            list.add(nums[i]);
            backtrack(nums,target-nums[i],i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
}
