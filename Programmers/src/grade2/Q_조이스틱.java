class Solution {
	public int solution(String name) {
		int answer = 0;
		return answer;
	}

	public int joyStick(String name, String tmp, int count) {
		if (name.equalsIgnoreCase(tmp)) {
			return count;
		} else {

		}
	}

	public int greedy(String name, String tmp, int index) {
		int right = 0;
		int left = 0;

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != tmp.charAt(i)) {
				right = i;
				break;
			}
		}

		for (int i = name.length() - 1; i >= 0; i++) {
			if (name.charAt(i) != tmp.charAt(i)) {
				left = -(name.length() - i);
				break;
			}
		}
	}
}
