class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(n,1,k,ans,new ArrayList<>());
        return ans;
    }
    private void backtrack(int n,int indx, int k, List<List<Integer>> ans, List<Integer> list){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=indx;i<=n;i++){
            list.add(i);
            backtrack(n,i+1,k,ans,list);
            list.remove(list.size()-1);
        }
    }
}