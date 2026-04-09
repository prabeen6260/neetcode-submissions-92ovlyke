class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap<>();
        for(String string:strs){
            char[] freq=new char[26];
            for(char c:string.toCharArray()){
                freq[c-'a']++;
            }
            String s=new String(freq);
            map.computeIfAbsent(s,k->new ArrayList<>()).add(string);
       }
       List<List<String>> ans =new ArrayList<>(map.values());
       return ans;
    }
}
