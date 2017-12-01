class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n < 2:
            return 0
        preProfit = [0]*n; postProfit = [0]*n
        curMin = prices[0]; curMax = prices[-1]
        for i in range(1, n):
            p = prices[i]
            preProfit[i] = max(preProfit[i-1], p - curMin)
            curMin = min(curMin, p)
        for i in range(n-2, -1, -1):
            p = prices[i]
            postProfit[i] = max(postProfit[i+1], curMax - p)
            curMax = max(curMax, p)

        maxProfit = 0
        for i in range(n):
            maxProfit = max(maxProfit, preProfit[i] + postProfit[i])
        return maxProfit