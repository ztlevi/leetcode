class Solution:
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums = sorted(candidates)
        ans = []
        self.helper(nums, 0, [], target, ans)
        return ans
        
    def helper(self, nums, start, cur, res, ans):
        if res == 0:
            ans.append(list(cur))
            return
        elif res < 0:
            return
        for i in range(start, len(nums)):
            if i > start and nums[i] == nums[i-1]:
                continue
            cur.append(nums[i])
            self.helper(nums, i+1, cur, res-nums[i], ans)
            cur.pop()