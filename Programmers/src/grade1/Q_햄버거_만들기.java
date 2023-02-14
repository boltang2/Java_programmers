import java.util.Stack;

class Solution {
	public int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < ingredient.length; i++) {
			stk.push(ingredient[i]);
			if (stk.size() >= 4) {
				int makeHamberger = 0;
				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						makeHamberger = stk.elementAt(stk.size() - (j + 1)) == 1 ? ++makeHamberger : 0;
					} else if (j == 1) {
						makeHamberger = stk.elementAt(stk.size() - (j + 1)) == 3 ? ++makeHamberger : 0;
					} else if (j == 2) {
						makeHamberger = stk.elementAt(stk.size() - (j + 1)) == 2 ? ++makeHamberger : 0;
					} else if (j == 3) {
						makeHamberger = stk.elementAt(stk.size() - (j + 1)) == 1 ? ++makeHamberger : 0;
					}
				}
				if (makeHamberger == 4) {
					for (int j = 0; j < 4; j++) {
						stk.pop();
					}
					answer++;
				}
			}
		}
		return answer;
	}
}