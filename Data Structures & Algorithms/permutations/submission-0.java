class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new boolean[nums.length],new ArrayList<>());
        return ans;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> path){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            path.add(nums[i]);
            backtrack(nums,used,path);
            path.remove(path.size()-1);
            used[i]=false;
        }
        
    }
}
