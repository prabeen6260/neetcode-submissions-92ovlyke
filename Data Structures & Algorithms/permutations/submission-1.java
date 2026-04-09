class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag=new boolean[nums.length];
        backtrack(nums,flag,new ArrayList<>());
        return ans;
    }
    private void backtrack(int[] nums, boolean[] flag, List<Integer> list){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag[i])continue;
            flag[i]=true;
            list.add(nums[i]);
            backtrack(nums,flag,list);
            list.remove(list.size()-1);
            flag[i]=false;
        }
    }
}
