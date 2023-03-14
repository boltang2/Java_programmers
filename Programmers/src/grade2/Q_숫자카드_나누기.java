import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		isD(arrayA, arrayB);
		answer = Math.max(isD(arrayA, arrayB), isD(arrayB, arrayA));
		return answer;
	}

	public int isD(int[] a, int[] b) {
		ArrayList<Integer> fac = new ArrayList<Integer>();
		out: for (int i = 2; i <= a[0]; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] % i != 0) {
					continue out;
				}
			}
			fac.add(i);
		}
		out2: for (int i = fac.size() - 1; i >= 0; i--) {
			for (int j = 0; j < b.length; j++) {
				if (b[j] % fac.get(i) == 0) {
					continue out2;
				}
			}
            return fac.get(i);
		}
		return 0;
	}
}