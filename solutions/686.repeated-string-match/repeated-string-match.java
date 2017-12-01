class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int n = 1;
        while (sb.length() < B.length()) {
            sb.append(A);
            n++;
        }
        if (sb.indexOf(B) >= 0) return n;
        sb.append(A);
        n++;
        if (sb.indexOf(B) >= 0) return n;
        return -1;
    }
}