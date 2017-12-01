class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        gasLeft = 0
        start = 0
        gasNeeded = 0
        for i, (g, c) in enumerate(zip(gas, cost)):
            gasLeft += g - c
            if gasLeft < 0:
                start = i + 1
                gasNeeded -= gasLeft
                gasLeft = 0

        return start if gasNeeded <= gasLeft else -1
                