class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        m = {0: -1}
        curSum = 0
        for i in range(len(nums)):
            n = nums[i]
            curSum += n
            if k != 0:
                curSum %= k
            prev = m.get(curSum)
            if prev != None:
                if i - prev > 1: return True
            else:
                m[curSum] = i
        return False
