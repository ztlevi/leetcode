public class Solution {
    public String convertToTitle(int n) {
        if(n==0) return "";
        int startIdx = (int)('A');
        Map<Integer, Character> map = new HashMap();
        for(int i = 0; i < 26; i++){
            map.put(i, (char)(startIdx+i));
        }
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int curr = (n-1)%26;
            sb.append(map.get(curr));
            n = (n - curr)/26;
        }
        sb = sb.reverse();
        return new String(sb);
    }
}