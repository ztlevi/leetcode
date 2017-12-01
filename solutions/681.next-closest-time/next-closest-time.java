import java.util.*;
class Solution {
    public String nextClosestTime(String time) {
        Set<Character> digits = new HashSet();
        digits.add(time.charAt(0));
        digits.add(time.charAt(1));
        digits.add(time.charAt(3));
        digits.add(time.charAt(4));
        int stime = Integer.parseInt(time.substring(0,2)) * 60 +
                Integer.parseInt(time.substring(3,5));

        int n = digits.size();
        int pdiff = Integer.MAX_VALUE;
        int ndiff = 0;
        String pcan = "";
        String ncan = "";

        for (char i : digits){
            for (char j : digits) {
                for (char k : digits) {
                    for (char l : digits) {
                        String candidate = ""+i + ""+j + ":" + ""+k + ""+l;
                        if (isValidTime(candidate)) {
                            int curtime = Integer.parseInt(candidate.substring(0,2)) * 60 +
                                    Integer.parseInt(candidate.substring(3,5));
                            int curDiff = curtime - stime;
                            if (curDiff > 0) {
                                if (pdiff > curDiff) {
                                    pdiff = curDiff;
                                    pcan = candidate;
                                }
                            } else if (curDiff < 0) {
                                if (ndiff > curDiff) {
                                    ndiff = curDiff;
                                    ncan = candidate;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (pcan != "") return pcan;
        else if (ncan != "") return ncan;
        else return time;
    }

    public boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        if (hour >= 0 && hour < 24 && min >= 0 && min < 60) {
            return true;
        }
        return false;
    }

}