class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        lastLevel = [1, 1]
        thisLevel = [1]
        for l in range(1, rowIndex+1):
            thisLevel = [1]
            for i in range(l-1):
                thisLevel.append(lastLevel[i] + lastLevel[i+1])
            thisLevel.append(1)
            lastLevel = thisLevel
        return thisLevel
    