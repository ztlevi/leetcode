// Forward declaration of the knows API.
bool knows(int a, int b);

class Solution {
public:
    int findCelebrity(int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if(knows(left, right)) {
                left ++;
            } else {
                right --;
            }
        }
        for (int i = 0; i < n; i ++) {
            if (i==left || (knows(i, left) && !knows(left, i))) {
                continue;
            } else {
                return -1;
            }
        }
        return left;
    }
};