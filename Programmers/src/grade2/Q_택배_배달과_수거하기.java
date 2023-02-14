import java.util.Arrays;

class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int deliveriesIndex = notZeroIndex(deliveries, n - 1);
		int pickupsIndex = notZeroIndex(pickups, n - 1);
		while (isArrEmpty(deliveries, deliveriesIndex) || isArrEmpty(pickups, pickupsIndex)) { // ���/��Ȱ�� ��� �Ҷ����� 
			
			answer += Math.max(deliveriesIndex, pickupsIndex) + 1; // �����/������ ���� �� �հ��� �������� �����Ѵ�.

			/*
			 * ex) del = [1,0,2,0,3], cap 4, index = 4
			 * 	      �ؿ� �� �Լ� ó����(pickups�� ����)
			 *     del = [1,0,1,0,0], cap 4, index = 3
			 */
			
			deliveries = afterDelivery(deliveries, deliveriesIndex, cap);
			deliveriesIndex = notZeroIndex(deliveries, deliveriesIndex);

			pickups = afterDelivery(pickups, pickupsIndex, cap);
			pickupsIndex = notZeroIndex(pickups, pickupsIndex);

		}
		return answer * 2; // �պ� �Ÿ� �̹Ƿ� �ι�
	}

	private static int notZeroIndex(int[] arr, int lastIndex) { // �ش� �迭�� �ڿ��� ���� ������ ó������ 0�� �ƴ� �ε����� ��ȯ
		int index = 0;
		boolean isZero = true;
		for (int i = lastIndex; i >= 0; i--) {
			if (arr[i] != 0 && isZero) {
				isZero = false;
				index = i;
				break;
			}
		}
		return index;
	}

	private static boolean isArrEmpty(int[] arr, int lastIndex) { // �ش� �迭�� ���� ������ �ε��� ���� �˻��� ��� 0 �̸� false, �� �ܿ��� true
		boolean isEmpty = false;
		for (int i = 0; i <= lastIndex; i++) {
			if (arr[i] > 0) {
				isEmpty = true;
				break;
			}
		}
		return isEmpty;
	}

	private static int[] afterDelivery(int[] arr, int lastIndex, int stack) { // ���� �ѹ��� ������ �� �ִ� ���뷮 ��ŭ �ڿ� ������ ���� ��� �� ����� ��ŭ
																		      // �ش� ���� �����/��Ȱ�� �ù踦 ����.
		for (int i = lastIndex; i >= 0; i--) {
			if (stack - arr[i] >= 0) {
				stack -= arr[i];
				arr[i] = 0;
			} else {
				arr[i] -= stack;
				stack = 0;
				break;
			}
		}
		return arr;
	}
}