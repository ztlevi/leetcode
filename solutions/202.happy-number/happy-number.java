public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(!set.contains(n)){
            if(n == 1) return true;
            set.add(n);
            n = getNextHappy(n);
        }
        return false;
    }
    public int getNextHappy(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n%10, 2);
            n = n/10;
        }
        return sum;
    }
}