class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        Deque<Character>stack=new ArrayDeque<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        for(char b:s.toCharArray()){
            if(map.containsKey(b)){
                if(stack.peek()==map.get(b))stack.pop();
                else return false;
            }
            else stack.push(b);
        }
        return stack.isEmpty();
    }
}
