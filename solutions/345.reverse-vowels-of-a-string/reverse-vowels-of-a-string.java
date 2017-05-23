public class Solution {
    public String reverseVowels(String s) {
        // vowels are a, e, i, o, u
        if (s.length() == 0) return "";
        int i = 0, j = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while (i < j) {
            while (!isVowel(s.charAt(i) ) && i < j) {
                i++;
            }
            if (i >= j) break;
            while (!isVowel(s.charAt(j) ) && i < j) {
                j--;
            }
            if (i >= j) break;
            sb.setCharAt(i, s.charAt(j) );
            sb.setCharAt(j, s.charAt(i) );
            j--; i++;
        }
        return new String(sb);
    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'A' ||
            c == 'e' || c == 'E' || 
            c == 'i' || c == 'I' || 
            c == 'o' || c == 'O' || 
            c == 'u' || c == 'U') {
            return true;
        }
        else return false;
    }
}