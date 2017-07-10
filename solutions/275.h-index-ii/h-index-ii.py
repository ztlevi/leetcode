class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if not citations:
            return 0
        max = 0
        n = len(citations)
        low, high = 0, n-1
        
        while low <= high:
            currh = 0
            mid = (low + high) /2
            if n-mid >= citations[mid]:
                low = mid + 1
            else:
                high = mid - 1
            currh = min(citations[mid], n-mid)
            if currh > max:
                max = currh

        return max