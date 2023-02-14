import javax.swing.text.MaskFormatter;

class Solution {
	private int[] maxSales = new int[2]; // maxSales[0] = maxSubs, maxSales[1] = maxEmoticonSales

	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = {};
		double[] sales = { 0.1, 0.2, 0.3, 0.4 };
		int dfsSize = emoticons.length;
		double[] curNode = new double[dfsSize];
		dfs(users, emoticons, 0, dfsSize, sales, curNode);
		return maxSales;
	}

	private void dfs(int[][] users, int[] emoticons, int cur, int size, double[] sales, double[] curNode) { // 모든 할인 경우의 수를 구해 cal 호출
		if (cur == size) {
			cal(users, emoticons, curNode);
			return;
		}
		for (int i = 0; i < sales.length; i++) {
			curNode[cur] = sales[i];
			dfs(users, emoticons, cur + 1, size, sales, curNode);
		}
		return;
	}

	private void cal(int[][] users, int[] emoticons, double[] curNode) {
		// 1) 모든 유저의 가져와 정보를 가져와 해당 할인(curNode)율 적용한 이모지 가격을 모두 더해
		// 초과할 경우 maxSales++, 그 외 maxEmoticonSales += 모두 더한 이모지 가격
		// 단 해당 유저의 할인율을 넘지 않으면 더하지 않음.
		int userSale; // 해당 유저가 구매한 이모티콘 가격
		int maxSub = 0; // 구독한 유저 수
		int maxSale = 0; // 구독하지 않은 모든 유저의 이모티콘 구매 가격을 합친 수
		boolean isOver; // break 구분동작 변수
		for (int[] userName : users) { // 모든 유저
			userSale = 0;
			isOver = false;
			for (int i = 0; i < emoticons.length; i++) { // 모든 이모티콘들
				if ((double) userName[0] / 100 <= curNode[i]) { // 유저가 정한 할인율 보다 높은경우 해당 이모티콘 구매
					userSale += emoticons[i] * (1 - curNode[i]);
				}
				if (userSale >= userName[1]) { // 순자 검색중 반복문이 끝나기 전에 이미 넘어버리면 뒤에거 계산할 필요 없이 반복문 벗어남
					isOver = true;
					break;
				}
			}
			if (isOver) { // 유저가 정한 가격을 초과한 경우 구독하고 다음 유저로 넘어감
				maxSub++;
			} else {
				maxSale += userSale; // 해당 유저가 구독을 하지 못한 경우 이모티콘 구매 가격 추가
			}
		}
		// 2) 해당 maxSub, maxSale을 전역변수로 선언한 maxSales에 주기적으로 갱신
		// 0 10800 1 5400
		if(maxSales[0] < maxSub) { // 우선순위는 maxSub 구독수가 증가한 경우 해당 값으로 [0], [1]갱신
			maxSales[0] = maxSub;
			maxSales[1] = maxSale;
		} else if(maxSales[0] == maxSub) { // 구독수가 같은 상태에서 이모티콘 구매값이 증가한 경우 [1]갱신
			if(maxSales[1] < maxSale) {
				maxSales[1] = maxSale;
			}
		}
	}
}