class Solution(object):
    def numDecodings(self, s):
        v, w, p = 0, int(s>''), ''
        for d in s:
            lastState = w
            w= (d>'0')*w + (9<int(p+d)<27)*v
            v = lastState
            p = d
        return w
