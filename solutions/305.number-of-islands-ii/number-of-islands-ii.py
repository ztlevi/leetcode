class Solution(object):
    def numIslands2(self, m, n, positions):
        def find(x):
            if parent[x] != x:
                return find(parent[x])
            else:
                return x

        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                if rank[x] < rank[y]:
                    y, x = x, y
                parent[y] = x
                rank[x] += rank[x] == rank[y]
                count[0] -= 1
        
        parent, rank = {}, {}
        counts, count = [], [0]
        for i, j in positions:
            x = parent[x] = i, j
            rank[x] = 0
            count[0] += 1
            for y in (i+1, j), (i-1, j), (i, j-1), (i, j+1):
                if y in parent:
                    union(x, y)
            counts.append(count[0])
            
        return counts