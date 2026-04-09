class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        stack=new ArrayDeque<>();
        min=new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!min.isEmpty() && val<=min.peek())min.push(val);
        else if(min.isEmpty())min.push(val);
    }
    
    public void pop() {
        int val=stack.pop();
        if(min.peek()==val)min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
