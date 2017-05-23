public class Solution {
    
    public int bulbSwitch(int n) {
    return (int)Math.sqrt(n);
}
    // public int bulbSwitch(int n) {
    //     int count = 0;
    //     for(int i = 1; i <= n; i++){
    //         if(helper(i) % 2 == 1)
    //             count++;
    //     }

    //     return count;
    // }
    // public int helper(int n){
    //     int count= 0;
    //     for(int i = 1; i <= n; i++){
    //         if(n % i == 0)
    //             count++;
    //     }
    //     return count;
    // }
}