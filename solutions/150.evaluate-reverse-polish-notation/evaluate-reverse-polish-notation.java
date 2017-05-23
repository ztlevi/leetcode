public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        if(tokens.length==2) return 0;
        
        LinkedList<Integer> stack = new LinkedList();
        stack.push(Integer.parseInt(tokens[0]));
        stack.push(Integer.parseInt(tokens[1]));
        int ans = 0;
        for(int i=2; i<tokens.length; i++){
            int n1,n2;
            switch(tokens[i]){
            case "+": 
                n1 = stack.poll();
                n2 = stack.poll();
                stack.push(n1+n2);
                continue;
            case "-":
                n1 = stack.poll();
                n2 = stack.poll();
                stack.push(n2-n1);
                continue;
             case "*":   
                n1 = stack.poll();
                n2 = stack.poll();
                stack.push(n1*n2);
                continue;
             case "/": 
                n1 = stack.poll();
                n2 = stack.poll();
                stack.push(n2/n1);
                continue;
            }    
            stack.push(Integer.parseInt(tokens[i]));
            
        }
        
        return stack.peek();
    }
}