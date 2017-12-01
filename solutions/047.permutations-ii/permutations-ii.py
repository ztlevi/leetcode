class Solution(object):
    def permuteUnique(self, nums):
        ans = []
        self.dfs(nums, 0, [], ans)
        return ans
    
    def dfs(self, nums, start, cur, ret):
        if start == len(nums):
            ret.append(list(cur))
            return
        for i in range(len(cur)+1):
            self.dfs(nums, start+1, cur[:i]+[nums[start]]+cur[i:], ret)
            if i < len(cur) and cur[i] == nums[start]:
                break
