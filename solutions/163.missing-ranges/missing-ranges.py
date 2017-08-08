class Solution(object):
    def findMissingRanges(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: List[str]
        """
        ret = []

        arr = [lower-1] + nums + [upper+1]
        last = arr[0]
        for curr in arr:
            if curr - last == 2:
                ret.append(str(last+1))
            elif curr - last > 2:
                ret.append(str(last+1) + "->" + str(curr-1))
                
            last = curr
        return ret   