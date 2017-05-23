class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not s:
            return ""
        
        indices = {} # store the t chars' indexes
        for c in t:
            indices[c] =[]
        miss = list(t)
        start = 0
        end = len(s) - 1

        for i in range(len(s)):
            c = s[i]
            if c in t:
                if not c in miss:
                    indices[c].pop(0)
                elif c in miss:
                    miss.remove(c)
                indices[c].append(i)

                if not miss:
                    minimum = min(x[0] for x in indices.values())
                    maximum = max(x[-1] for x in indices.values())
                    if maximum - minimum + 1 < end - start + 1:
                        start = minimum
                        end = maximum
                    
        if miss == []:
            return s[start: end+1]
        else:
            return ""


