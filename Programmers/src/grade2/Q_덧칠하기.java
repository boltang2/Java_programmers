import java.util.Stack;

class Solution {
	public int solution(int n, int m, int[] section) {
		int answer = 0;
		Stack<Integer> sec = new Stack<Integer>();
		for (int i = 0; i < section.length; i++) {
			sec.push(section[i]);
		}

		while (!sec.isEmpty()) {
			int wall = sec.pop();
	
			while (sec.peek() >= wall - (m - 1) && !sec.isEmpty()) {
				sec.pop();
			}
			answer++;
		}
		return answer;
	}
}

// wall = 6 m =4
// 3