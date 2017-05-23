class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.target = target
        self.rst = []
        for i in range(1, len(num)+1):
            val = num[:i]
            if i == 1 or (i > 1 and num[0] != '0'):
                self.dfs(num[i:], val, int(val), int(val))
        return self.rst

    # dfs(num, rstString, cur, last)
    def dfs(self, num, rstString, cur, last):
        if not num and cur == self.target:
            self.rst.append(rstString)

        for i in range(1, len(num)+1):
            val = num[:i]
            if i == 1 or (i > 1 and num[0] != '0'):
                self.dfs(num[i:], rstString+'+'+val, cur+int(val), int(val))
                self.dfs(num[i:], rstString+'-'+val, cur-int(val), -int(val))
                self.dfs(num[i:], rstString+'*'+val, cur-last+last*int(val), last*int(val))

