import java.util.Stack;

class Solution {
	public int solution(String s) {
		int answer = 0;
		Stack<String> stk = new Stack<>();
		while (s.length() > 0) {
			int countX = 0;
			int countOther = 0;
			char x = s.charAt(0);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == x) {
					countX++;
				} else {
					countOther++;
				}
				if (countX == countOther || i == s.length() - 1) {
					stk.push(s.substring(0, i + 1));
					s = s.substring(i + 1);
					break;
				}
			}
		}
		answer = stk.size();
		return answer;
	}
}