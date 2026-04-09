class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> stack=new ArrayDeque<>();
        for(char bracs:s.toCharArray()){
            if(!stack.isEmpty() && map.get(bracs)==stack.peek())stack.pop();
            else stack.push(bracs);
        }
        return stack.isEmpty();
    }
}
