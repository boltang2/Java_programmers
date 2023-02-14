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

	private void dfs(int[][] users, int[] emoticons, int cur, int size, double[] sales, double[] curNode) { // ��� ���� ����� ���� ���� cal ȣ��
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
		// 1) ��� ������ ������ ������ ������ �ش� ����(curNode)�� ������ �̸��� ������ ��� ����
		// �ʰ��� ��� maxSales++, �� �� maxEmoticonSales += ��� ���� �̸��� ����
		// �� �ش� ������ �������� ���� ������ ������ ����.
		int userSale; // �ش� ������ ������ �̸�Ƽ�� ����
		int maxSub = 0; // ������ ���� ��
		int maxSale = 0; // �������� ���� ��� ������ �̸�Ƽ�� ���� ������ ��ģ ��
		boolean isOver; // break ���е��� ����
		for (int[] userName : users) { // ��� ����
			userSale = 0;
			isOver = false;
			for (int i = 0; i < emoticons.length; i++) { // ��� �̸�Ƽ�ܵ�
				if ((double) userName[0] / 100 <= curNode[i]) { // ������ ���� ������ ���� ������� �ش� �̸�Ƽ�� ����
					userSale += emoticons[i] * (1 - curNode[i]);
				}
				if (userSale >= userName[1]) { // ���� �˻��� �ݺ����� ������ ���� �̹� �Ѿ������ �ڿ��� ����� �ʿ� ���� �ݺ��� ���
					isOver = true;
					break;
				}
			}
			if (isOver) { // ������ ���� ������ �ʰ��� ��� �����ϰ� ���� ������ �Ѿ
				maxSub++;
			} else {
				maxSale += userSale; // �ش� ������ ������ ���� ���� ��� �̸�Ƽ�� ���� ���� �߰�
			}
		}
		// 2) �ش� maxSub, maxSale�� ���������� ������ maxSales�� �ֱ������� ����
		// 0 10800 1 5400
		if(maxSales[0] < maxSub) { // �켱������ maxSub �������� ������ ��� �ش� ������ [0], [1]����
			maxSales[0] = maxSub;
			maxSales[1] = maxSale;
		} else if(maxSales[0] == maxSub) { // �������� ���� ���¿��� �̸�Ƽ�� ���Ű��� ������ ��� [1]����
			if(maxSales[1] < maxSale) {
				maxSales[1] = maxSale;
			}
		}
	}
}