# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        start = 1; end = n

        while end - start > 1:
            mid = (start + end) / 2
            if isBadVersion(mid):
                end = mid
            else:
                start = mid
            
        if isBadVersion(start):
            return start
        else:
            return end

