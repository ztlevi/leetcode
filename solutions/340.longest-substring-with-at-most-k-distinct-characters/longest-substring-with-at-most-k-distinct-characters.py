class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        dic = {}
        maxLen = 0
        low = 0
        for i, c in enumerate(s):
            dic[c] = i
            if len(dic) > k:
                m = min(dic.values())
                del dic[s[m]]
                low = m + 1
            maxLen = max(maxLen, i - low + 1)
        return maxLen
    