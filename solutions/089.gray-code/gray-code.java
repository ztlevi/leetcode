public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode(n-1);
        int addNum = 1<<(n-1);

        for (int i = result.size()-1; i >=0; i--) {
            result.add(result.get(i) + addNum);
        }

        return result;
    }
}