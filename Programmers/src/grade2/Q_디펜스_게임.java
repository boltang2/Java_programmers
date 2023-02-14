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
		if (left == index) { // ���� Ž�� ����
			maxRound = left;
		} else {
			boolean rightMove = isWin(mySoldier, fightEnemyArr(enemy, invinTicket, index));
			if (rightMove) { // ���������� �̵�
				left = index + 1;
			} else {
				right = index - 1;
			}
			defenseRound(mySoldier, invinTicket, enemy, left, right);
		}

	}

	// �ε��� ��ŭ �迭�� �߶󳻼� ������ �� ���� �� Ƽ������ ó���� ���带 ���� ������ �迭�� ����
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

	// ������ ������ ���� ���� ���� ���� ���� ũ�ٸ� false / �۴ٸ� true ����
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