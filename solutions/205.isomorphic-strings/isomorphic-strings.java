class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        
        for (int i = 0 ; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (s2t.containsKey(cs)) {
                if (ct != s2t.get(cs)) return false;
            } else {
                s2t.put(cs, ct);
            }
            if (t2s.containsKey(ct)) {
                if (cs != t2s.get(ct)) return false;
            } else {
                t2s.put(ct, cs);
            }
        }
        return true;
    }
}