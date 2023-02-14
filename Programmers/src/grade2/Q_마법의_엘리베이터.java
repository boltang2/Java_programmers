import java.util.Stack;
import java.util.stream.Stream;

class Solution {
	int minStone = 0;

	public int solution(int storey) {
		int answer = 0;
		String str = "0" + Integer.toString(storey);
		int[] digit = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
		int[] curNode = new int[digit.length];
		boolean[] roundUp = { false, true };
		dfs(digit, curNode, digit.length - 1, roundUp);
		return minStone;
		
	}
	
	private int[] arrAsInt(int[] arr, int cur) { // 덧셈 올림 경우
		String str = "";
		int leng = arr.length;
		int[] digit = new int[arr.length];
		for (int i = 0; i < leng; i++) {
			str += Integer.toString(arr[i]);
		}
		str = Integer.toString((Integer.parseInt(str) + (int) Math.pow(10, leng - cur)));
		if (str.length() < arr.length) {
			str = "0" + str;
		}
		for (int i = 0; i < str.length(); i++) {
			digit[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		System.out.println("arrAsInt");
		return digit;
	}

	private int[] arrAsArr(int[] arr) { // 그냥 배열 복사
		int[] digit = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			digit[i] = arr[i];
		}
		return digit;
	}

	// 이진트리 탐색
	private void dfs(int[] digit, int[] curNode, int cur, boolean[] roundUp) {
		// [0,1,2,3,4]
		if (cur == 0) {
			curNode[cur] = digit[0];
			cal(curNode);
			return;
		} else if (digit[cur] == 0) {
			curNode[cur] = 0;
			dfs(arrAsArr(digit), curNode, cur - 1, roundUp);
		} else {
			for (int i = 0; i < roundUp.length; i++) {
				if (!roundUp[i]) {
					curNode[cur] = digit[cur];
					dfs(arrAsArr(digit), curNode, cur - 1, roundUp);
				} else {
					curNode[cur] = 10 - digit[cur];
					dfs(arrAsInt(digit, cur), curNode, cur - 1, roundUp);
				}
			}
		}
		return;
	}

	private void cal(int[] curNode) {
		int sum = sum(curNode);
		if (minStone == 0) {
			minStone = sum;
		} else if (minStone > sum) {
			minStone = sum;
		}
	}

	private int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private void show(int[] curNode) {
		for (int i = 0; i < curNode.length; i++) {
			System.out.print(curNode[i] + " ");
		}
		System.out.println();
	}
}