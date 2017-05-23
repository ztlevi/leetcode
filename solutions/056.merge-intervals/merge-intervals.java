/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        for(int i = 0; i < intervals.size(); i++) {
            boolean reversei = false;
            for(int j = i + 1; j < intervals.size(); j++) {
                Interval n = intervals.get(i);
                Interval m = intervals.get(j);
                if(!(n.end < m.start || n.start > m.end) ) {
                    intervals.set(i, new Interval(Math.min(n.start, m.start), Math.max(n.end, m.end) ) );
                    intervals.remove(j--);
                    reversei = true;
                }
            }           
            if(reversei) i--;
        }
        return intervals;
    }     
}