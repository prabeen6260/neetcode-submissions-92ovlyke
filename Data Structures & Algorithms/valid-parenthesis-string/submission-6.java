class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> wildCard=new ArrayDeque<>();
        Deque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else if(!wildCard.isEmpty()){
                   wildCard.pop(); 
                }
                else return false;
            }
            else if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(s.charAt(i)=='*'){
                wildCard.push(i);
            }
        }
        while(!stack.isEmpty() && !wildCard.isEmpty()){
            if(wildCard.pop()<stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
