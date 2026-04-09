class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] freq = new char[26];
            for(int i=0;i<s.length();i++){
                freq[s.charAt(i)-'a']++;
            }
            String key = new String(freq);
            map.computeIfAbsent(key,k->new ArrayList<>()).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list:map.values()){
            ans.add(list);
        }
        return ans;
    }
}
