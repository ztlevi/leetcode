class Solution {
    public String findLongestWord(String s, List<String> d) {
        d.sort(Comparator.comparing((String x) -> -x.length()).thenComparing((x)->(x)));
        for (String word : d) {
            int idx = 0;
            for (char c : s.toCharArray()) {
                if (idx >= word.length()) break;
                if (c == word.charAt(idx)) {
                    idx++;
                }
            }
            if (idx == word.length()) return word;
        }
        
        return "";
    }

}