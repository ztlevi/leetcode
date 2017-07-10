import heapq
class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        min = mid = max = float('-inf')
        for n in nums:
            if n > max:
                min, mid, max = mid, max, n
            elif n > mid and n < max:
                min, mid = mid, n
            elif n > min and n < mid:
                min = n
        if min > float('-inf'):
            return min
        else:
            return max

        