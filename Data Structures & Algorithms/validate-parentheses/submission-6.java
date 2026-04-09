class Solution {
    public boolean isValid(String s) {
       int n=s.length();
       if(n%2!=0)return false;
       Deque<Character> stack=new ArrayDeque<>();
       for(char c:s.toCharArray()){
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else return false;
            }
            else if(c=='}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }
                else return false;
            }
            else if(c==']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }
                else return false;
            }
            else{
                stack.push(c);
            }
       }
       return stack.isEmpty();
    }
}
