class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] scnt = new int[256];

        
        int[] gcnt = new int[256];
        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if (g == s) {
                bulls++;
            }else {
                if (scnt[g] > 0) cows++;
                if (scnt[s] < 0) cows++;
                scnt[g]--;
                scnt[s]++;
            }
        }

        return bulls+"A"+cows+"B";
    }
}