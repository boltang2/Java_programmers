class Solution {
	public int solution(int n, long l, long r) {
		return sumToleft(n - 1, r, 0) - sumToleft(n - 1, l - 1, 0);
	}

	public int sumToleft(int n, long x, int result) {
		if (n < 0) {
			return result;
		} else {
			int p = (int) Math.pow(5, n);
			int sum = (int) Math.pow(4, n);
			long remainX = x % p; // 0 ~ p - 1
			x /= p; // 0 ~ 4
			if (x >= 3) {
				result += sum * (int) (x - 1);
			} else if (x == 2) {
				result += sum * (int) x;
				return result;
			} else {
				result += sum * (int) x;
			}
			return sumToleft(n - 1, remainX, result);
		}
	}
}
