class Solution(object):
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        def search(s):
            if s not in mem:
                mem[s] = any(not search(s[:i] + '--' + s[i+2:]) for i in range(len(s)) if s[i:i+2] == '++')
            return mem[s]
        mem = {}
        return search(s) 