class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return ans;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(digits,map,0,new StringBuilder());
        return ans;
    }
    private void backtrack(String digits,Map<Character,String> map,int start,StringBuilder string){
        if(string.length()==digits.length()){
            ans.add(string.toString());
            return;
        }
        String c=map.get(digits.charAt(start));
        for(char s:c.toCharArray()){
            string.append(s);
            backtrack(digits,map,start+1,string);
            string.deleteCharAt(string.length()-1);
        }
    }
}
