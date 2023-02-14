import java.util.HashMap;
import java.util.Map;

class Solution {
	public String solution(String[] survey, int[] choices) {
		int[] score = { 0, 3, 2, 1, 0, 1, 2, 3 };
		int[][] charactor = new int[4][2]; // RT CF JM AN 순으로 sore 저장
		String[] category = { "RT", "CF", "JM", "AN", "TR", "FC", "MJ", "NA" };
		String answer = "";
		// [RT TR CF FC JM MJ AN NA]
		Map<String, int[]> map = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			map.put(category[i], charactor[i]);
		}
		for (int i = 0; i < survey.length; i++) { // survey
			for (int k = 0; k < category.length; k++) { // category
				if (category[k].equals(survey[i])) {
					if (k < 4) {
						if (choices[i] > 3) {
							charactor[k][1] += score[choices[i]];
						} else {
							charactor[k][0] += score[choices[i]];
						}
						map.put(category[k], charactor[k]);
						break;
					} else {
						if (choices[i] > 3) {
							charactor[k - 4][0] += score[choices[i]];
						} else {
							charactor[k - 4][1] += score[choices[i]];
						}
						map.put(category[k - 4], charactor[k - 4]);
						break;
					}
				}
			}
		}
		for (String key : map.keySet()) {
			int[] mbti = map.get(key);
			if(mbti[0] < mbti[1]) {
				answer += key.charAt(1);
			} else {
				answer += key.charAt(0);
			}
		}
		return answer;
	}
}
