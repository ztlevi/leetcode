class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums
        

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        import random
        count = 0
        arr = []
        for i in range(len(self.nums)):
            n = self.nums[i]
            if n == target:
                arr.append(i)
        idx = random.randrange(len(arr))
        return arr[idx]



# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)