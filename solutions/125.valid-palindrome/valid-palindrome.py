class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        import string
        if not s:
            return True

        def isAlphaNumeric(c):
            if c in string.ascii_lowercase or c in string.digits:
                return True

        l, r = 0, len(s) - 1
        while True:
            while l < len(s) and not isAlphaNumeric(s[l].lower()):
                l += 1
            while r >= 0 and not isAlphaNumeric(s[r].lower()):
                r -= 1
            if l >= r:
                return True
            if s[l].lower() != s[r].lower():
                return False
            else:
                r -= 1
                l += 1
