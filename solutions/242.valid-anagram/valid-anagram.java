public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a = string2Chars(s);
        char[] b = string2Chars(t);
        return Arrays.equals(a,b);
    }
    public char[] string2Chars(String s){
        char[] a = new char[26];
        for(int i=0; i<s.length(); i++){
            a[s.charAt(i)-'a']++;
        }
        return a;
    }
}