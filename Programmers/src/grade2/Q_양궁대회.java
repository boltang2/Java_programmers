class Solution {

	int maxDiffer = 0;
	int[] answer = new int[11];

	public int[] solution(int n, int[] apeach) {
		int[] lion = new int[11];
		archery(lion, apeach, n, 0);
		if (maxDiffer > 0) {
			return answer;
		} else {
			return new int[] { -1 };
		}
	}

	public void archery(int[] lion, int[] apeach, int n, int index) {
		// 메서드 벗어나는 분기점
		if (n == 0 || index == 11) {
			lion[index - 1] += n;
			int differ = lionWin(lion, apeach);
			maxDiffer = target(differ, maxDiffer, lion);
		} else {
			// 다음 재귀에 들어갈 tmp[] 생성
			int[] tmp = copyCurIndex(lion, index);
			// 해당 과녁에 화살을 쏘지 않을 경우 다음 과녁으로
			archery(tmp, apeach, n, index + 1);
			// 해당 과녁에 화살을 쏠 경우
			// n보다 apeach[index]값이 더 클 경우
			if (n <= apeach[index]) {
				tmp[index] = n;
			} else {
				tmp[index] = apeach[index] + 1;
			}
			archery(tmp, apeach, n - tmp[index], index + 1);
		}
	}

	public int[] copyCurIndex(int[] lion, int index) {
		int tmp[] = new int[11];
		for (int i = 0; i < index; i++) {
			tmp[i] = lion[i];
		}
		return tmp;
	}

	public int lionWin(int[] lion, int[] apeach) {
		int lionScore = 0;
		int apeachScore = 0;

		for (int i = 0; i < lion.length; i++) {
			if (lion[i] + apeach[i] > 0) {
				if (lion[i] > apeach[i]) {
					lionScore += 10 - i;
				} else if (lion[i] <= apeach[i]) {
					apeachScore += 10 - i;
				}
			}
		}

		int differ = lionScore - apeachScore;

//		if (differ >= maxDiffer) {
//			System.out.printf("lion : %d, apeach : %d\n", lionScore, apeachScore);
//		}

		return differ > 0 ? differ : -1;
	}

	public int target(int differ, int maxDiffer, int[] lion) {
		if (maxDiffer > differ) {
			return maxDiffer;
		}
		if (maxDiffer == differ) {
			for (int i = 10; i >= 0; i--) {
				if (answer[i] > lion[i]) {
					break;
				} else if (answer[i] < lion[i]) {
					answer = lion;
					break;
				}
			}
		} else if (maxDiffer < differ) {
//			System.out.printf("maxDiffer : %d , differ : %d\n", maxDiffer, differ);
			answer = lion;
			maxDiffer = differ;

//			for (int i = 0; i < answer.length; i++) {
//				System.out.print(answer[i] + " ");
//			}
//			System.out.println();
		}
		return differ;
	}
}