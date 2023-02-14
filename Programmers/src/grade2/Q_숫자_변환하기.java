import java.util.HashSet;

class Solution {
	public int solution(int x, int y, int n) {
		int answer = 0;
		HashSet<Integer> cur = new HashSet<>();
		HashSet<Integer> next = null;
		int cnt = 0;
		int[] branch = { 2, 3, n };
		cur.add(x);

		while (!cur.isEmpty()) {
			if (cur.contains(y)) {
				return cnt;
			} else {
				next = new HashSet<>();
				for (int fac : cur) {
					for (int i = 0; i < branch.length; i++) {
						int nextFac = 0;
						if (i < 2) {
							nextFac = fac * branch[i];
						} else {
							nextFac = fac + branch[i];
						}
						if (nextFac <= y) {
							next.add(nextFac);
						}
					}
				}
			}
			cnt++;
			cur = next;
		}

		return -1;
	}
}
