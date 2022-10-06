class MinStack {
    
    class Pair{
        int val;
        int minVal;
        
        Pair(int v, int mv){
            val = v;
            minVal = mv;
        }
    }

    Stack<Pair> st = new Stack<>();
    
    public MinStack() {
        st = new Stack<Pair>();
    }
    
    public void push(int val) {
    
        if(st.isEmpty()){
            st.push(new Pair(val, val));
        }
        else{
            int minV = st.peek().minVal;
            
            st.push(new Pair(val, Math.min(minV, val)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */