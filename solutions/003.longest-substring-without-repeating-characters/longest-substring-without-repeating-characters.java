public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;

        while(j < s.length()) {

            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            ans = Math.max(j - i + 1, ans);
            j++;
        }
        return ans;

    }
}