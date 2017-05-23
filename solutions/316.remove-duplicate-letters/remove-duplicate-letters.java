public class Solution {
    public String removeDuplicateLetters(String s) {
        //cbacdcbc
        //c - 7， b - 6， a - 2， d - 4
        //找0-2，3-4，5-6，7-7中最小的char
        Map<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        StringBuilder sb = new StringBuilder();
        int start = 0, end = findSmallestIndex(map);

        while (!map.isEmpty()) {
            char curr = 'z' + 1;
            int index = 0;
            for (int i = start; i <= end; i++) {
                char c = s.charAt(i);
                if (c < curr && map.containsKey(c)) {
                    curr = c;
                    index = i;
                }
            }

            sb.append(curr);
            map.remove(curr);

            start = index + 1;
            end = findSmallestIndex(map);
        }

        return sb.toString();
    }
    
    public int findSmallestIndex(Map<Character, Integer> map) {
        int result = Integer.MAX_VALUE;
        for (int num : map.values()) {
            result = Math.min(result, num);
        }
        return result;
    }
}