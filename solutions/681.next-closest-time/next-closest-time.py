class Solution:
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        tset = set(time)
        t = list(map(int, time.split(':')))
        sec = t[0]*60+t[1]
        lessTime = ''
        for i in range(24*60):
            t = '{:02d}:{:02d}'.format(*divmod(i, 60))
            if set(t) <= tset:
                if not lessTime:
                    lessTime = t
                if i > sec:
                    return t
        return lessTime