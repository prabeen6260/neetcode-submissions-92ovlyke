class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] freq = new char[26];
            for(char c: s.toCharArray()){
                int index = c-'a';
                freq[index]++;
            }
            String key =new String(freq);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}
