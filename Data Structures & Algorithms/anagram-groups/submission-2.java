class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map= new HashMap<>();
       for(String string:strs){
        char[] str=string.toCharArray();
        Arrays.sort(str);
        String s=new String(str);
        if(map.containsKey(s)){
            map.get(s).add(string);
        }
        else{
            map.put(s,new ArrayList<>());
            map.get(s).add(string);
        }
       }
       List<List<String>> ans =new ArrayList<>(map.values());
       return ans;
    }
}
