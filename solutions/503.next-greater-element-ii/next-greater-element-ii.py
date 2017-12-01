class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        stack = []
        dic= {}
        res = [-1] * len(nums)

        for _ in range(2):
            for i in range(len(nums) -1, -1, -1):
                n = nums[i]
                while stack and stack[-1] <= n:
                    stack.pop()
                if stack:
                    res[i] = stack[-1]
                stack.append(n)

        return res
        
        