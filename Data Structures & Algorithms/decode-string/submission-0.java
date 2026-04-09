class Solution {
    String ans ="";
    public String decodeString(String s) {
        Deque<String> stack_s=new ArrayDeque<>();
        Deque<Integer>stack_k=new ArrayDeque<>();
        StringBuilder currString=new StringBuilder();
        int currInt=0;
        int i=0;
        while(i<s.length()){
            if(Character.isLetter(s.charAt(i))){
                currString.append(s.charAt(i));
                i++;
            }
            else if(Character.isDigit(s.charAt(i))){
                while(Character.isDigit(s.charAt(i))){
                    currInt=currInt*10+s.charAt(i)-'0';
                    i++;
                }
            }else if(s.charAt(i)=='['){
                stack_s.push(currString.toString());
                stack_k.push(currInt);
                currString=new StringBuilder();
                currInt=0;
                i++;
            }
            else if(s.charAt(i)==']'){
                int n=stack_k.pop();
                String temp=currString.toString().repeat(n);
                currString.setLength(0);
                currString.append(stack_s.pop()).append(temp);
                i++;
            }
        }
        return currString.toString();
    }
}