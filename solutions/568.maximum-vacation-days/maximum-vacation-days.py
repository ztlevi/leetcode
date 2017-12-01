class Solution:
    def maxVacationDays(self, flights, days):
        """
        :type flights: List[List[int]]
        :type days: List[List[int]]
        :rtype: int
        """
        N = len(flights)
        K = len(days[0])
        
        dp = [float('-inf')] * N
        dp[0] = 0
        # i week
        # j : to city
        # k : from city
        for i in range(K):
            new = [float('-inf')] * N
            for j in range(N):
                for k in range(N):
                    if (flights[k][j] == 1 or j == k):
                        new[j] = max(new[j], dp[k] + days[j][i])
                        
            dp = new
        return max(dp)