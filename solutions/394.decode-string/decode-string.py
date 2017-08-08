class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        ret = ""
        stack = [["", 1]]
        num = ""
        for c in s:
            if c.isdigit():
                num += c
            elif c == '[':
                stack.append(["", num])
                num = ""
            elif c == ']':
                string, k = stack.pop()
                stack[-1][0] += string * int(k)
            else:
                stack[-1][0] += c
        return stack[0][0]

# so = Solution()
# so.decodeString("3[abc]2[a]")
