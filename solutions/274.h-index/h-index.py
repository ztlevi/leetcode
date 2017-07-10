class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if not citations:
            return 0
        counter = [0]*(len(citations)+1)
        n = len(counter)
        for c in citations:
            if c > n-1:
                c = n-1
            counter[c] += 1

        sum = 0
        for i in range(n-1, -1, -1):
            sum += counter[i]
            if sum >= i:
                return i
        return 0
        