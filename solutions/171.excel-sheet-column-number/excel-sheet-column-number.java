public class Solution {
    public int titleToNumber(String s) {
        Map<Character, Integer> map = new HashMap();
        int startIdx = (int)('A');
    
        for(int i = 0; i < 26; i++){
            map.put((char)(i+startIdx), i + 1);
        }
        
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans = ans * 26;
            ans += map.get(s.charAt(i));
        }
        return ans;
    }
}