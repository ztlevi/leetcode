class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        // corner case


        int N = flights.length, K = days[0].length;
        int[] dp = new int[N]; // dp[i][j] is max days on week i at city j
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1 ) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }
        int mx = 0;
        for (int v : dp) {
            mx = Math.max(mx, v);
        }
        return mx;
    }
}