class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if abs(len(s) - len(t)) > 1:
            return False
        l = min(len(s), len(t))
        i, j = 0, 0
        while i < l and s[i] == t[i]:
            i += 1
        while j < l-i and s[~j] == t[~j]:
            j += 1
        # i+j is the length of the same chars
        return max(len(s), len(t)) - (i + j) == 1