class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        cnt = 0
        for idx in range(len(nums)):
            i = idx + 1
            j = len(nums) - 1
            
            while i < j:
                if nums[i] + nums[j] >= target - nums[idx]:
                    j -= 1
                else:
                    cnt += j - i
                    i += 1
        return cnt
    