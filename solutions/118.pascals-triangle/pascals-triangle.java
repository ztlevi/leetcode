public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList(numRows);
        if (numRows == 0) return new ArrayList();
        
        List<Integer> temp = new ArrayList();
        temp.add(1);
        list.add(temp);
        if (numRows == 1) return list;
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> iRow = new ArrayList();
            
            iRow.add(1);
            for (int j = 1; j < i - 1; j++){
                List<Integer> preRow = list.get(i-2);
                int num = preRow.get(j-1) + preRow.get(j);
                iRow.add(num);
            }
            iRow.add(1);
            list.add(iRow);
        }
        return list;
    }
}