class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] c= s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                map.put(key,new ArrayList<>(Arrays.asList(s)));
            }
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}
