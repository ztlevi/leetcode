class Solution:
    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        def isSub(word):
            it = iter(s)
            return all(c in it for c in word)
        d.sort(key= lambda x : (-len(x), x))
        return next(filter(isSub, d), '')