class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        self.dp = [-1]*(target+1)
        self.dp[0] = 1 # means target == n
        return self.helper(nums, target)

    def helper(self, nums, target):
        if self.dp[target] != -1:
            return self.dp[target]
        res = 0
        for n in nums:
            if target >= n:
                res += self.helper(nums, target-n)

        self.dp[target] = res
        return res

so = Solution()
so.combinationSum4([1,2,3], 1)
