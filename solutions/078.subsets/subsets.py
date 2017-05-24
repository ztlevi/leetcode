class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.rst = [[]]
        self.dfs(nums)
        return self.rst
        
    def dfs(self, nums):
        if not nums:
            return
        else:
            n = nums[0]

        for l in range(len(self.rst)):
            r = list(self.rst[l])
            r.append(n)
            self.rst.append(r)
        nums.pop(0)
        self.dfs(nums)

