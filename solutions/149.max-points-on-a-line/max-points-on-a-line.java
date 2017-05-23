/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        int ans = 1;

        for(int i = 0; i < points.length-1; i++){
            int max = 1;
            Map<Double, Integer> m = new HashMap();
            Map<Integer, Integer> vertical = new HashMap();
            int samePoint = 0;
            for(int j = i+1; j < points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                    continue;
                }
                if(points[i].x == points[j].x){
                    if(!vertical.containsKey(points[i].x)){
                        vertical.put(points[i].x, 2);
                    }
                    else{
                        vertical.put(points[i].x, vertical.get(points[i].x) + 1);
                    }
                    max = Math.max(max, vertical.get(points[i].x));
                }else{
                    double slope = (points[i].y == points[j].y)? 0 : (1.0*(points[i].y-points[j].y))/(points[i].x-points[j].x);     
                    if(!m.containsKey(slope)){
                        m.put(slope, 2);
                    }else{
                        m.put(slope, m.get(slope)+1);
                    }
                    max = Math.max(max, m.get(slope));
                }
            }
            ans = Math.max(ans, max + samePoint);
        }
        return ans;
    }

}