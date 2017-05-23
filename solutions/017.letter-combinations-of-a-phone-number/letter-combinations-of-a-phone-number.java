public class Solution {
    public List<String> letterCombinations(String digits) {
        int len=digits.length();
        
        if (len == 0) return new ArrayList();
        char[][] c = {"abc".toCharArray(), "def".toCharArray(), "ghi".toCharArray(),
            "jkl".toCharArray(), "mno".toCharArray(), "pqrs".toCharArray(), "tuv".toCharArray(), "wxyz".toCharArray()};
        ArrayList<String> list = new ArrayList();

        int idxOf2 = (int)'2';
        for (int i = 0; i < len; i++){
            int digit = (int)digits.charAt(i)-idxOf2;
            list = helper(list, c[digit]);
        }

        return list;
    }
    
    public ArrayList<String> helper(ArrayList<String> list, char[] c) {
        if (list.isEmpty()) {
            for (int i = 0; i < c.length; i++){
                list.add(String.valueOf(c[i]));
            }
            return list;
        }
        
        ArrayList<String> ans = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < c.length; j++){
                ans.add(list.get(i) + c[j]);
            }
        }
        return ans;
    }
    
}