public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int dup=0;
        if(!(G<=A || C<=E || B>=H || D<=F)){
            int[] x={A,C,E,G}; int[] y={B,D,F,H};
            Arrays.sort(x); Arrays.sort(y);
            dup=(x[2]-x[1])*(y[2]-y[1]);
        }
            
        return (C-A)*(D-B)+(G-E)*(H-F)-dup;
    }
}