class Solution(object):
    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        def helper(cur, pos, count):
            if pos == len(word):
                rst.append(cur+(str(count) if count != 0 else ''))
            else:
                helper(cur, pos+1, count+1)
                if count > 0:
                    helper(cur + str(count) + word[pos], pos+1, 0)
                else:
                    helper(cur + word[pos], pos+1, 0)
            
        rst = []
        helper('', 0, 0)
        return rst