class Solution(object):
    def wordsTyping(self, sentence, rows, cols):
        """
        :type sentence: List[str]
        :type rows: int
        :type cols: int
        :rtype: int
        """
        rst = []
        s = ' '.join(sentence) + ' '
        idx = 0; l = len(s)
        for i in range(rows):
            idx += cols
            if s[idx % l] == ' ': # works for len(s) < cols
                idx += 1
            else:
                while idx > 0 and s[(idx - 1) % l] != ' ': # trim the idx
                    idx -= 1
        return idx / l
    