public class Solution {
    public int romanToInt(String s) {
		if(s == null)
			return 0;

        int result = 0;

        Map<Character, Integer> m = new HashMap();
        m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

		int len = s.length();
		result += m.get(s.charAt(len-1));
		for(int i = len-2; i >= 0; i--){
			if(m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))){
				result += m.get(s.charAt(i));
			}else{
				result -= m.get(s.charAt(i));
			}
		}

		return result;
    }
}