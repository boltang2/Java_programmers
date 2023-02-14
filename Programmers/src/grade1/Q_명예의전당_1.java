import java.util.Arrays;

class Solution {
	public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		int[] topKScore = new int[k];
		for (int i = 0; i < score.length; i++) {
			if (i < k) {
				topKScore[0] = score[i];
				Arrays.sort(topKScore);
//        		for(int tmp : topKScore) {
//        			System.out.println(tmp);	
//        		}
//        		System.out.println("---------");
				answer[i] = topKScore[k - i - 1];
			} else {
//        		for(int tmp : topKScore) {
//    			System.out.println(tmp);	
//    		}
//    		System.out.println("---------");
				if (topKScore[0] < score[i]) {
					topKScore[0] = score[i];
				}
				Arrays.sort(topKScore);
				answer[i] = topKScore[0];
			}
		}
		return answer;
	}
}