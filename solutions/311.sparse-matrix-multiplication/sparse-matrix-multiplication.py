class Solution(object):
    def multiply(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: List[List[int]]
        """
        n, m, l = len(A), len(A[0]), len(B[0])
        if m != len(B):
            raise Exception("Len of A, B not valid")
        C = [[0 for _ in range(l)] for _ in range(n)]
    
        for i,row in enumerate(A):
            for j, eleA in enumerate(row) :
                if eleA:
                    for z, eleB in enumerate(B[j]):
                        if eleB:
                            C[i][z] += eleA * eleB
                            
        return C