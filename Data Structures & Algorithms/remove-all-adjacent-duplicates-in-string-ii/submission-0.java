class Solution {
    class Node{
        int count;
        char c;
        Node(){};
        Node(int count,char c){
            this.count=count;
            this.c=c;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        Deque<Node> stack=new ArrayDeque<>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!stack.isEmpty() && stack.peek().c==chars[i]){
                stack.peek().count+=1;
            }
            else{
                Node node =new Node(1,chars[i]);
                stack.push(node);
            }
            if(!stack.isEmpty() && stack.peek().count==k){
                stack.pop();
            }    
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            for(int i=0;i<node.count;i++){
                ans.append(node.c);
            }
        }
        return ans.reverse().toString();
    }
}