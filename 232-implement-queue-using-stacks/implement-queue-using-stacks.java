class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1=new ArrayDeque<>();
        stack2=new ArrayDeque<>();

    }
    
    public void push(int x) {
        while(!stack1.isEmpty()){
            int ch=stack1.pop();
            stack2.push(ch);
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            int ch=stack2.pop();
            stack1.push(ch);
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */