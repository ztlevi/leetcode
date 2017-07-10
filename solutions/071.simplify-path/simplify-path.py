class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        arr = path.split('/')
        rst = []

        for i in range(len(arr)):
            a = arr[i]
            if a == '.' or a == "":
                continue
            elif a == "..":
                l = len(rst)
                if l > 0:
                    rst.pop()
            else:
                rst.append(a)
        rstString = ""
        for r in rst:
            rstString += "/" + r
        if not rstString:
            return "/"
        else:
            return rstString

