public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(Character c : s.toCharArray()){
            if("([{".contains(String.valueOf(c))){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && peekValid(stack.peek(), c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean peekValid(Character a, Character b){
        if((a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}')) 
            return true;
        else return false;
    }
}