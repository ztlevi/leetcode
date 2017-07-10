class Solution(object):
    def wallsAndGates(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        q = []
        for i, row in enumerate(rooms):
            for j, c in enumerate(row):
                if c == 0:
                    q.append((i, j))

        for i, j in q:
            for I, J in (i+1, j), (i-1, j), (i, j+1), (i, j-1):
                if 0 <= I < len(rooms) and 0 <= J < len(rooms[0]) and rooms[I][J] == 2147483647:
                    rooms[I][J] = rooms[i][j] + 1
                    q.append((I,J))
        