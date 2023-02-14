import java.util.Arrays;

class Solution {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		row_begin--;
		String xor = "";

		Arrays.sort(data, (p1, p2) -> {
			if (p1[col - 1] == p2[col - 1]) {
				return p2[0] - p1[0];
			} else {
				return p1[col - 1] - p2[col - 1];
			}
		});

		for (int i = row_begin; i < row_end; i++) {
			String second = convertBit(data[i], i);
			xor = bitwizeXOR(xor, second);
		}
		System.out.println(xor);
		int answer = convertNum(xor);
		return answer;
	}

	public String bitwizeXOR(String first, String second) {

		String result = "";

		if (first.length() < second.length()) { // 비트 개수 통일화 하기
			for (int i = first.length(); i < second.length(); i++) {
				first = "0" + first;
			}
		} else {
			for (int i = second.length(); i < first.length(); i++) {
				second = "0" + second;
			}
		}

		for (int i = 0; i < first.length(); i++) {
			int bit = Integer.parseInt(first.substring(i, i + 1)) + Integer.parseInt(second.substring(i, i + 1));
			if (bit % 2 == 0) {
				result += "0";
			} else {
				result += "1";
			}
		}
		return result;
	} // bitwizeXOR

	public String convertBit(int[] data, int i) {
		int s_I = 0;
		String bit = "";
		for (int j = 0; j < data.length; j++) {
			s_I += (data[j] % (i + 1));
		}
		if (s_I == 0) {
			bit = "0";
		} else {
			while (s_I > 0) {
				if (s_I % 2 == 0) {
					bit = "0" + bit;
				} else {
					bit = "1" + bit;
				}
				s_I /= 2;
			}
		}
		return bit;
	} // convertBit

	public int convertNum(String xor) {
		int count = (int) Math.pow(2, xor.length() - 1);
		int result = 0;
		for (int i = 0; i < xor.length(); i++) {
			result += count * Integer.parseInt(xor.substring(i, i + 1));
			count /= 2;
		}
		return result;
	} // convertNum
}

//for (int i = 0; i < data.length; i++) {
//	for (int j = 0; j < data[i].length; j++) {
//		System.out.print(data[i][j] + " ");
//	}
//	System.out.println();
//}