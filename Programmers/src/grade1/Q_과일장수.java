import java.util.Arrays;

class Solution {
	public int solution(int k, int m, int[] score) {
		int answer = 0;
		Arrays.sort(score);
//		for (int tmp : score) {
//			System.out.print(tmp + " ");
//		}
		if (score.length % m != 0) {
			score = Arrays.copyOfRange(score, score.length % m, score.length);
		}
//		while (score.length > 0) {
//			if (score[0] == k) {
//				answer += score[0] * score.length;
//				break;
//			} else {
//				answer += score[0] * m;
//				score = Arrays.copyOfRange(score, m, score.length);
//			}
//		}
		for(int i = 0; i < score.length; i+=m) {
			if(score[i] == k) {
				answer += score[i] * (score.length - i);
				break;
			} else {
				answer += score[i] * m;
			}
		}
		return answer;
	}
}
