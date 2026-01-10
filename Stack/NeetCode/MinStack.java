------------------
USING TWO STACKS
------------------
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if(min.isEmpty() || min.peek()>=val){
            min.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(min.peek().equals(stack.peek()))
            min.pop();
        if(!stack.isEmpty())
            stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
