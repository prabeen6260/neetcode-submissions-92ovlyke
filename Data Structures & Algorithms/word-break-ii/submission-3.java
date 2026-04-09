class Solution {
    Map<Integer,List<String>> memo=new HashMap<>();
    Set<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        return backtrack(s,0);
    }
    private List<String> backtrack(String s,int i){
        if(memo.containsKey(i))return memo.get(i);
        List<String> ans=new ArrayList<>();
        if(i==s.length()){
            ans.add("");
            return ans;
        }
        for(int j=i+1;j<=s.length();j++){
            String word=s.substring(i,j);
            if (set.contains(word)){
                List<String> rest=backtrack(s,j);

                for(String restWord:rest){
                    if(!restWord.isEmpty()){
                        ans.add(word+" "+restWord);
                    }
                    else ans.add(word);
                }
            }
        }
        memo.put(i,ans);
        return ans;
    }
}