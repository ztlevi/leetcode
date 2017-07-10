class Solution:
    # @param s, a list of 1 length strings, e.g., s = ['h','e','l','l','o']
    # @return nothing
    def reverseWords(self, s):
        s.reverse()

        lastIdx = 0
        for i in range(len(s)):
            if s[i] == ' ':
                s[lastIdx : i] = reversed(s[lastIdx : i])
                lastIdx = i + 1
        
        s[lastIdx:] = reversed(s[lastIdx:])