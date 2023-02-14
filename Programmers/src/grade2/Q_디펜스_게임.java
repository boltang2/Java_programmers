import java.util.Arrays;
import java.util.Stack;

class Solution {
	int maxRound = 0;

	public int solution(int n, int k, int[] enemy) {
		if (k >= enemy.length) {
			return k;
		} else {
			defenseRound(n, k, enemy, k, enemy.length - 1);
			return maxRound;
		}
	}

	public void defenseRound(int mySoldier, int invinTicket, int[] enemy, int left, int right) {
		int index = (left + right) / 2;
		if (left == index) { // 이진 탐색 종료
			maxRound = left;
		} else {
			boolean rightMove = isWin(mySoldier, fightEnemyArr(enemy, invinTicket, index));
			if (rightMove) { // 오른쪽으로 이동
				left = index + 1;
			} else {
				right = index - 1;
			}
			defenseRound(mySoldier, invinTicket, enemy, left, right);
		}

	}

	// 인덱스 만큼 배열을 잘라내서 오름차 순 정렬 후 티켓으로 처리할 라운드를 없앤 나머지 배열을 리턴
	public int[] fightEnemyArr(int[] enemy, int invinTicket, int index) {
		int[] halfEnemy = Arrays.copyOf(enemy, index + 1);
		Arrays.sort(halfEnemy);
		halfEnemy = Arrays.copyOf(halfEnemy, halfEnemy.length - invinTicket);
		for (int i = 0; i < halfEnemy.length; i++) {
			System.out.print(halfEnemy[i] + " ");
		}
		System.out.println();
		return halfEnemy;
	}

	// 나머지 라운드의 합이 내가 가진 솔져 보다 크다면 false / 작다면 true 리턴
	public boolean isWin(int mySoldier, int[] fightEnemy) {
		for (int i = 0; i < fightEnemy.length; i++) {
			mySoldier -= fightEnemy[i];
			if (mySoldier < 0) {
				return false;
			}
		}
		return true;
	}
}