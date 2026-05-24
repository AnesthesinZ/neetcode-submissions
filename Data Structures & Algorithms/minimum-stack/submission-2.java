class MinStack {

    class StackValue {
        int originValue;
        int minValue;

        public StackValue(int originValue, int minValue) {
            this.originValue = originValue;
            this.minValue = minValue;
        }
    }

    Stack<StackValue> stack = new Stack<>();
    int curMin = Integer.MAX_VALUE;

    public MinStack() {
    
    }
    
    public void push(int val) {
        curMin = Math.min(val, curMin);
        stack.add(new StackValue(val, curMin));
    }
    
    public void pop() {
        stack.pop();
        curMin = getMin();
    }
    
    public int top() {
        return stack.peek().originValue;
    }
    
    public int getMin() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stack.peek().minValue;
    }
}
