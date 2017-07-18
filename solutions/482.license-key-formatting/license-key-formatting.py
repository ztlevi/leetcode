class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        parts = S.split('-')
        s = ''.join(parts)
        s = s.upper()
        l1 = len(s) % K
        ret = ""
        for i in range(l1):
            ret += s[i]
        idx = l1
        while idx < len(s):
            if idx != 0:
                ret += '-'
            for i in range(idx, idx + K):
                ret += s[i]
            idx = idx + K
        return ret
            
        