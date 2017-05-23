public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        helper(n,n,list,"");
        return list;
    }
    
    public void helper(int left, int right, List<String> list, String par){
        if (left == 0 && right == 0) {
            list.add(par);
            return;
        } 
        
        if (left > 0) {
            helper(left-1, right, list, par+'(');
        }    
        
        if (right > 0 && left < right) {
            helper(left, right-1, list, par+')');
        }
    }
 }