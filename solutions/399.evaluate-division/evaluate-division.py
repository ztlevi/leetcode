class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        dic = collections.defaultdict(dict)  # chr1 : {chr2 : val}
        for i in range(len(equations)):
            a, b = equations[i][0], equations[i][1]
            dic[a][b] = values[i]
            dic[b][a] = 1 / values[i]
            dic[a][a] = dic[b][b] = 1

        for i in dic:
            for j in dic[i]:
                for k in dic[i]:
                    dic[j][k] = dic[j][i] * dic[i][k]
        return [dic[a].get(b, -1.0) for a, b in queries]