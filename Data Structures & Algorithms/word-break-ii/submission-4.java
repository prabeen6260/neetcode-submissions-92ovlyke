class Solution {
    Map<Integer,List<String>> map;
    Set<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        map=new HashMap<>();
        set=new HashSet<>(wordDict);
        return dfs(s,0);
    }
    private List<String> dfs(String s,int i){
        if(map.containsKey(i))return map.get(i);
        List<String> ans = new ArrayList<>();
        if(i==s.length()){
            ans.add("");
            return ans;
        }
        for(int j=i+1;j<=s.length();j++){
            String word=s.substring(i,j);
            if(set.contains(word)){
                List<String> restWords=dfs(s,j);
                for(String rest:restWords){
                    if(!rest.isEmpty()){
                        ans.add(word+" "+rest);
                    }
                    else ans.add(word);
                }
            }
        }
        map.put(i,ans);
        return ans;
    }
}