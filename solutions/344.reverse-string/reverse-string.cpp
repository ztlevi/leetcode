class Solution {
public:
    string reverseString(string s) {
        string rs;  //reverse String
        for(int numOfChar = 0; numOfChar < s.length(); numOfChar++)
        {
          rs += s[s.length() - numOfChar-1];
        }
        return rs;
    }
};