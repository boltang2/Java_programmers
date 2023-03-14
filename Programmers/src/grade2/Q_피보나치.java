import java.util.ArrayList;

class Solution {
	public int solution(int n) {
		int answer = 0;
		ArrayList<Integer> fi = new ArrayList<Integer>();
		fi.add(0);
		fi.add(1);
		for (int i = 2; i <= n; i++) {
			int next = (fi.get(i - 2) + fi.get(i - 1)) % 1234567;
			fi.add(next);
		}
		return fi.get(n);
	}
}
