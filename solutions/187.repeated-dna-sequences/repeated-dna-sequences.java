public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        
        if (s.length() <= 10) return ans;
        
        Set<String> set = new HashSet<String>();
        for (int i = 10; i <= s.length(); i++) {
            String substr = s.substring(i-10, i);
            if (set.contains(substr)) {
                if (!ans.contains(substr))
                    ans.add(substr);
            } else {
                set.add(substr);
            }
        }
        return ans;
    }
}