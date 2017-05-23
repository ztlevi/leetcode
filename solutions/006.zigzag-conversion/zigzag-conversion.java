public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += 2*(numRows-1)) {
                if (i == 0 || i == numRows-1)
                    sb.append(s.charAt(j));
                else {
                    sb.append(s.charAt(j));
                    int foo = j + 2*(numRows-i-1);
                    if (foo < s.length())
                        sb.append(s.charAt(foo));
                }
            }
        }
        return new String(sb);
    }
}