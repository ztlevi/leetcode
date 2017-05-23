public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
            
        for (int i = 0; i < haystack.length(); i++) {
            if (check(haystack, i, needle))
                return i;
        }
        return -1;
    }
    
    public boolean check(String haystack, int start, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (start + i >= haystack.length() || 
                haystack.charAt(start+i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}