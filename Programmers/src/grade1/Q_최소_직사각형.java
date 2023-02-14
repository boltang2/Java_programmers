import java.util.Arrays;

class Solution {
	public int solution(int[][] sizes) {
		int answer = 0;
		int[] wid = new int[sizes.length];
		int[] leng = new int[sizes.length];
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > sizes[i][1]) {
				int tmp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = tmp;
			}
		}
		for (int i = 0; i < sizes.length; i++) {
			wid[i] = sizes[i][0];
			leng[i] = sizes[i][1];
		}		
		Arrays.sort(wid);
		Arrays.sort(leng);
		answer = wid[sizes.length - 1] * leng[sizes.length - 1];
		return answer;
	}
}
