class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack =new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int n=stack.pop();
        if(!minStack.isEmpty() && minStack.peek()==n)minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(!minStack.isEmpty())return minStack.peek();
        return -1;
    }
}
