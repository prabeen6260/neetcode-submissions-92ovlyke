class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(),ans);
        return ans;
    }
    private void backtrack(int open, int close,int n,StringBuilder string, List<String> ans){
        if(string.length()==n*2){
            ans.add(string.toString());
            return;
        }
        if(open<n){
            string.append("(");
            backtrack(open+1,close,n,string,ans);
            string.deleteCharAt(string.length()-1);
        }
        if(close<open){
            string.append(")");
            backtrack(open,close+1,n,string,ans);
            string.deleteCharAt(string.length()-1);
        }
    }
}
