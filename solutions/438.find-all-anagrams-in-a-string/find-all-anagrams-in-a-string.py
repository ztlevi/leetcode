class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        n, m = len(s), len(p)
        if n < m:
            return res
        shash, phash = [0]*128, [0]*128
        for x in p:
            phash[ord(x)] += 1
        for x in s[:m]:
            shash[ord(x)] += 1
        if phash == shash:
            res.append(0)
        for i in range(m, n):
            shash[ord(s[i])] += 1
            shash[ord(s[i-m])] -= 1
            if shash == phash:
                res.append(i-m+1)
        return res