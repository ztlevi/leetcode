class Solution {
public:
    int addDigits(int num) {
        if(num <= 9)
            return num;
        else return addDigits(num/10 + num%10);
    }
};