class StackNode{
    int val;
    int min;
    StackNode next;
    StackNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}

public class MinStack {
    /** initialize your data structure here. */
    public StackNode top;
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(top == null){
            top = new StackNode(x, x);
        }else{
	        StackNode foo = new StackNode(x, Math.min(x, top.min));
	        foo.next = top;
	        top = foo;
        }
    }
    
    public void pop() {
        StackNode foo = top.next;
        top = foo;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }

}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/