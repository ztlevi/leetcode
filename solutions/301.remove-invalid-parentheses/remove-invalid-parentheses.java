public class Solution {
    ArrayList<String> result = new ArrayList();
    int max = 0;
    
    public List<String> removeInvalidParentheses(String s) {
        if (s.length() != 0) {
            dfs(s, "", 0, 0);
        }
        
        if (result.size() == 0) {
            result.add("");      
        }
        return result;
    }

    // countLeft used for count the left parenthesis
    // maxString used to count the max possible result string
    public void dfs(String left, String right, int countLeft, int maxString) {
        if (left.length() == 0) {
            if (countLeft == 0) {
                max = (maxString > max) ? maxString : max;
                if (max == maxString && !result.contains(right))
                    result.add(right);
            }
            return;
        }

        if (left.charAt(0) == '(') {
            // keep ( first, then drop
            dfs(left.substring(1), right+"(", countLeft+1, maxString+1);
            dfs(left.substring(1), right, countLeft, maxString);
        } else if (left.charAt(0) == ')') {
            if (countLeft > 0) {
                dfs(left.substring(1), right+")", countLeft-1, maxString+1);
            }
            dfs(left.substring(1), right, countLeft, maxString);
        } else {
            char c = left.charAt(0);
            dfs(left.substring(1), right+c, countLeft, maxString+1);
        }
    }
}
