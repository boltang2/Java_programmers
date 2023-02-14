import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		HashMap<String, Integer> realTerms = new HashMap<>(); // terms 매핑
		String[] term = new String[2]; // terms (key, value)
		ArrayList<Integer> ex = new ArrayList<>(); // answer에 할당할 동적 배열 생성
		int[] answer = {}; // result

		for (String tmp : terms) { // realTerms
			term = tmp.split(" ");
			realTerms.put(term[0], Integer.parseInt(term[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] person = privacies[i].split(" "); // 해당 고객 개인정보 날짜와 상품 분리해서 저장
			String key = person[1]; // 해당 고객 상품;
            System.out.printf("%d + %d = %d < %d\n",getDate(person[0]),realTerms.get(key) * 28, 
                              getDate(person[0]) + realTerms.get(key) * 28, getDate(today));
			if(getDate(person[0]) + realTerms.get(key) * 28 <= getDate(today)) {
				ex.add(i + 1);
			}
		}

		return ex.stream().mapToInt(Integer::intValue).toArray();
	}

	private int getDate(String today) { // 날짜를 입력받아 날짜를 총 일수로 변환
		String[] date = today.split("\\.");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);

		return year * 12 * 28 + month * 28 + day;

	}
} // 굳이 날짜 비교할때 각각 계산하지말고 일수로 통합해서 계산하자... 진짜 개 멍청했다...
