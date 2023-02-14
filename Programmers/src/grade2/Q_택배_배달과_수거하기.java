import java.util.Arrays;

class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int deliveriesIndex = notZeroIndex(deliveries, n - 1);
		int pickupsIndex = notZeroIndex(pickups, n - 1);
		while (isArrEmpty(deliveries, deliveriesIndex) || isArrEmpty(pickups, pickupsIndex)) { // 배달/재활용 모두 할때까지 
			
			answer += Math.max(deliveriesIndex, pickupsIndex) + 1; // 배달할/수거할 곳중 젤 먼곳을 기준으로 가야한다.

			/*
			 * ex) del = [1,0,2,0,3], cap 4, index = 4
			 * 	      밑에 두 함수 처리후(pickups도 동일)
			 *     del = [1,0,1,0,0], cap 4, index = 3
			 */
			
			deliveries = afterDelivery(deliveries, deliveriesIndex, cap);
			deliveriesIndex = notZeroIndex(deliveries, deliveriesIndex);

			pickups = afterDelivery(pickups, pickupsIndex, cap);
			pickupsIndex = notZeroIndex(pickups, pickupsIndex);

		}
		return answer * 2; // 왕복 거리 이므로 두배
	}

	private static int notZeroIndex(int[] arr, int lastIndex) { // 해당 배열을 뒤에서 부터 조사해 처음으로 0이 아닌 인덱스를 반환
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

	private static boolean isArrEmpty(int[] arr, int lastIndex) { // 해당 배열을 내가 지정한 인덱스 까지 검사해 모두 0 이면 false, 그 외에는 true
		boolean isEmpty = false;
		for (int i = 0; i <= lastIndex; i++) {
			if (arr[i] > 0) {
				isEmpty = true;
				break;
			}
		}
		return isEmpty;
	}

	private static int[] afterDelivery(int[] arr, int lastIndex, int stack) { // 내가 한번에 적재할 수 있는 가용량 만큼 뒤에 집에서 부터 배달 후 배달한 만큼
																		      // 해당 집의 배달할/재활용 택배를 지움.
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