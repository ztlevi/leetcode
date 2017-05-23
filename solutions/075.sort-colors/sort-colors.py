class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        count = [0] * 3
        for n in nums:
            count[n] += 1
        a0,a1,a2 = count[0], count[1], count[2]
        nums[0:a0] = [0] * a0
        nums[a0: a0+a1] = [1] * a1
        nums[a0+a1: a0+a1+a2] = [2] * a2
        

