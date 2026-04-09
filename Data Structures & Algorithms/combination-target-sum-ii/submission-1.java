class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> check=new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtrack(candidates,target,0,new ArrayList<>());
        return ans;
    }
    private void backtrack(int[] candidates,int target,int start,List<Integer> list){
        int sum=0;
        for(int num: list)sum+=num;

        if(sum==target){
            list.sort((a,b)->a-b);
            if(!check.contains(list)){
                ans.add(new ArrayList<>(list));
                check.add(new ArrayList<>(list));
            }
        }
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            backtrack(candidates,target,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
