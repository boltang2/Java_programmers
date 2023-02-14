import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		HashMap<String, Integer> realTerms = new HashMap<>(); // terms ����
		String[] term = new String[2]; // terms (key, value)
		ArrayList<Integer> ex = new ArrayList<>(); // answer�� �Ҵ��� ���� �迭 ����
		int[] answer = {}; // result

		for (String tmp : terms) { // realTerms
			term = tmp.split(" ");
			realTerms.put(term[0], Integer.parseInt(term[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] person = privacies[i].split(" "); // �ش� �� �������� ��¥�� ��ǰ �и��ؼ� ����
			String key = person[1]; // �ش� �� ��ǰ;
            System.out.printf("%d + %d = %d < %d\n",getDate(person[0]),realTerms.get(key) * 28, 
                              getDate(person[0]) + realTerms.get(key) * 28, getDate(today));
			if(getDate(person[0]) + realTerms.get(key) * 28 <= getDate(today)) {
				ex.add(i + 1);
			}
		}

		return ex.stream().mapToInt(Integer::intValue).toArray();
	}

	private int getDate(String today) { // ��¥�� �Է¹޾� ��¥�� �� �ϼ��� ��ȯ
		String[] date = today.split("\\.");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);

		return year * 12 * 28 + month * 28 + day;

	}
} // ���� ��¥ ���Ҷ� ���� ����������� �ϼ��� �����ؼ� �������... ��¥ �� ��û�ߴ�...
