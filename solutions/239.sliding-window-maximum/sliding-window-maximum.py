import heapq
class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        pq = []
        res = []
        for i in range(len(nums)):
            if i >= k:
                pq.remove(nums[i - k])
            heapq.heappush(pq, nums[i])
            if i + 1 >= k:
                item = heapq.nlargest(1, pq)
                item = item[0]
                res.append(item)
        return res

