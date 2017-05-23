public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 1) continue;
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == '0' && j - i > 1) continue;
                if(dfs(num, 0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(String num, int i, int j, int k) {
        long n = Long.parseLong(num.substring(i, j));
        long m = Long.parseLong(num.substring(j, k));
        String sum = String.valueOf(n + m);

        if (!num.substring(k).startsWith(sum)) return false;
        if (num.substring(k).length() == sum.length()) return true;
        return dfs(num, j, k, k + sum.length());
    }
}