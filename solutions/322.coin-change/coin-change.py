import collections
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dic = [0] * (amount+1) # rem : least coin num
        def helper(rem):
            if rem < 0:
                return -1
            if rem == 0:
                return 0
            remCnt = dic[rem]
            if remCnt != 0: return remCnt
            minCoin = float('inf')
            for coin in coins:
                cnt = helper(rem - coin)
                if cnt >= 0 and cnt < minCoin:
                    minCoin = cnt
            # dic[rem - 1] = -1 if minCoin == float('inf') else minCoin
            # return dic[rem-1]
            if minCoin != float('inf'):
                dic[rem] = minCoin + 1
                return minCoin + 1
            else:
                dic[rem] = -1
                return -1

        ans = helper(amount)
        return ans

# so = Solution()
# # a = so.coinChange([1, 2, 5], 11)
# a = so.coinChange([186,419,83,408], 6249)
# print(a)