class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        size = 0
        tails = []
        for n in nums:
            i = bisect.bisect_left(tails, n)
            if i >= len(tails):
                tails.append(n)
            else: 
                tails[i] = n
            size = max(i + 1, size)
        return size