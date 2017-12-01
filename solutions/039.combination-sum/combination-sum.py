class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans = []
        self.helper(candidates, 0, [], target, ans)
        return ans
        
    def helper(self, nums, start, cur, res, ans):
        if res == 0:
            ans.append(list(cur))
            return
        elif res < 0:
            return
        for i in range(start, len(nums)):
            n = nums[i]
            cur.append(n)
            self.helper(nums, i, cur, res-n, ans)
            cur.pop()
            