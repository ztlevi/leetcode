class Codec:

    def encode(self, strs):
        """Encodes a list of strings to a single string.
        
        :type strs: List[str]
        :rtype: str
        """
        return ''.join('%d:' % len(s) + s for s in strs)

    def decode(self, s):
        """Decodes a single string to a list of strings.
        
        :type s: str
        :rtype: List[str]
        """
        rst = []
        i = 0
        while i < len(s):
            j = s.find(':', i)
            i = int(s[i:j]) + 1 + j
            rst.append(s[j+1:i])
        return rst
    

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))