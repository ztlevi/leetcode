class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        from heapq import *
        heap = []
        for i in nums:
            heappush(heap, i)
        for i in range(len(nums)-k):
            heappop(heap)
        return heappop(heap)
