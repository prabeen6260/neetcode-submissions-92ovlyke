class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> brac = new HashMap<>();
        brac.put(')','(');
        brac.put('}','{');
        brac.put(']','[');
        Deque<Character> stack = new ArrayDeque<>();
        for(char open: s.toCharArray()){
            if(brac.containsKey(open)){
                if(stack.isEmpty() || brac.get(open)!=stack.peek()){
                    return false;
                    }
                stack.pop();
            }
            else{
                stack.push(open);
            }
        }
        return stack.isEmpty();
    }
}
