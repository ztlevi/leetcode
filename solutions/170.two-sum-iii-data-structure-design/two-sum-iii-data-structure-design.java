public class TwoSum {

    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!map.containsKey(number))
            map.put(number, 1);
        else {
            int foo = map.get(number);
            map.put(number, foo+1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i : map.keySet()) {
            if (map.containsKey(value - i))
                if (value - i != i || map.get(i) > 1)
                    return true;
                
        }
        return false;
    }
}
