class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)return false;
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char brac = s.charAt(i);
            if(brac=='(')stack.push(')');
            else if(brac=='{')stack.push('}');
            else if(brac=='[')stack.push(']');
            else{
                if(stack.isEmpty() || stack.peek()!=brac)return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
