class Solution {
    Set<String> set;
    List<String> ans=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        List<String> list=new ArrayList<>();
        backtrack(s,0,list);
        return ans;
    }
    private void backtrack(String s, int indx, List<String> list){
        if(indx==s.length()){
            ans.add(String.join(" ",list));
            return;
        }
        for(int j=indx;j<s.length();j++){
            String word=s.substring(indx,j+1);
            if(set.contains(word)){
                list.add(word);
                backtrack(s,j+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}