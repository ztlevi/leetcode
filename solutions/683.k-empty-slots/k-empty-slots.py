class Solution:
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        N = len(flowers)
        pos = [] # idx : flower
        for day, flower in enumerate(flowers, 1):
            idx = bisect.bisect_left(pos, flower);
            for j in pos[idx-(idx>0):idx+1]:
                if abs(j-flower) == k+1:
                    return day
            pos.insert(idx, flower)
        return -1