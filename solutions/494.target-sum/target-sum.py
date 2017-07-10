class Solution(object):
    def findTargetSumWays(self, nums, S):
        count = {0: 1}
        for x in nums:
            count2 = {}
            for tmpSum in count:
                count2[tmpSum + x] = count2.get(tmpSum + x, 0) + count[tmpSum]
                count2[tmpSum - x] = count2.get(tmpSum - x, 0) + count[tmpSum]
            count = count2
        return count.get(S, 0)

# so = Solution()
# so.findTargetSumWays([1,1,1,1,1], 3)