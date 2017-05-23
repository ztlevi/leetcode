/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
            
        while (true) {
            int mid = low + (high - low)/2;
            int idy = guess(mid);
            if (idy == -1) {
                high = mid - 1;
            } else if (idy == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
    }
}