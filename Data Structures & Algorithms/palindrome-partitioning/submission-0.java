class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        return ans;
    }
    private void backtrack(String s, int start,List<String> list){
        if(start==s.length())ans.add(new ArrayList<>(list));
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                backtrack(s,i+1,list);
                list.remove(list.size()-1);
            }  
        }
    }
    private boolean isPalindrome(String s,int left, int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--))return false;
        }
        return true;
    }
}
