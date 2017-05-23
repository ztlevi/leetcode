public class Solution {
 public String longestPalindrome(String s) {
		String ans = "";
		for(int i = 0; i < s.length(); i++){
			String foo = expandPalindromFromCenter(s, i , i);
			ans = (foo.length() > ans.length()) ? foo : ans;
			foo = expandPalindromFromCenter(s, i , i + 1);
			ans = (foo.length() > ans.length()) ? foo : ans;
		}
		return ans;
	}

	public String expandPalindromFromCenter(String s, int l, int r){
		int left = l; int right = r;
		while(left >= 0 &&	right < s.length()){
				if(s.charAt(left) == s.charAt(right)){
					left--;
					right++;
				}else break;
		}
		return s.substring(left + 1, right);
	}
}
