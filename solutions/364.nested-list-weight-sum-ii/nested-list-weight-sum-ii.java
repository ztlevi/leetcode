/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int DFS(List<NestedInteger> nestedList, int lastSum) {
        if (nestedList.isEmpty()) return 0;
        
        List<NestedInteger> levelList = new ArrayList<NestedInteger>();
        int listSum = 0;

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                lastSum += ni.getInteger();
            } else {
                levelList.addAll(ni.getList());
            }
        }

        listSum += DFS(levelList, lastSum);
        return listSum + lastSum;
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return DFS(nestedList, 0);
    }
}