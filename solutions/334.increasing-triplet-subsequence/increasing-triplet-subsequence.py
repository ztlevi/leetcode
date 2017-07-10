class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        x = float('inf')
        y = float('inf')

        for z in nums:
            if z <= x:
                x = z
            elif z <= y:
                y = z
            else:
                return True

        return False
                