class Solution(object):
    def getMoneyAmount(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [[float('inf')] * (n+1) for _ in range(n+1)]
        return self.helper(1, n, dp)
        
    def helper(self, s, e, dp):
        if s >= e: return 0
        if dp[s][e] != float('inf'): return dp[s][e]
        rst = float('inf')
        for i in range(s, e+1):
            tmp = i + max(self.helper(s, i-1, dp), self.helper(i+1, e, dp))
            rst = min(rst, tmp)
        dp[s][e] = rst
        return rst