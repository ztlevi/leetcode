public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new TreeMap();
        map.put(1, "I"); map.put(4, "IV"); map.put(9, "IX");
        map.put(5, "V"); map.put(40, "XL");
        map.put(10, "X"); map.put(90, "XC");
        map.put(50, "L"); map.put(400, "CD");
        map.put(100, "C"); map.put(900, "CM");
        map.put(500, "D"); map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        while(num > 0){
            for(int i = keys.length-1; i >= 0; i--){
                int times = num/keys[i];
                num = num - times*keys[i];
                while(times > 0){
                    sb.append(map.get(keys[i]));
                    times--;
                }
            }
        }
        return new String(sb);
    }
}