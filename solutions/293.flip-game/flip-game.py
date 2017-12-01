class Solution(object):
    def generatePossibleNextMoves(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if not s:
            return []
        
        rst = []
        for i in range(1, len(s)):
            c = s[i]
            if c == '+' and s[i-1] == '+':
                rst.append(s[:i-1] + '--' + s[i+1:])
        return rst