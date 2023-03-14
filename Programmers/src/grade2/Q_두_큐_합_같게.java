import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		que(q1, queue1);
		que(q2, queue2);
		long q1_sum = sum(queue1);
		long q2_sum = sum(queue2);
		long avg = (q1_sum + q2_sum) / 2;
		System.out.println(avg);
		if ((q1_sum + q2_sum) % 2 == 1) {
			return -1;
		}
		int answer = 0;
		while (answer <= q1.size() * 4) {
			int tmp;
			System.out.println("q1 = " + q1 + ", q1_sum = " + q1_sum);
			System.out.println("q2 = " + q2 + ", q2_sum = " + q2_sum);
			if (Math.abs(avg - q1_sum) > Math.abs(avg - q2_sum)) {
				tmp = q1.poll();
				q2.add(tmp);
				q1_sum -= tmp;
				q2_sum += tmp;
			} else if (Math.abs(avg - q1_sum) < Math.abs(avg - q2_sum)) {
				tmp = q2.poll();
				q1.add(tmp);
				q2_sum -= tmp;
				q1_sum += tmp;
			}
			answer++;
			if (q1_sum == avg) {
				return answer;
			}
		}
		return -1;
	}

	public long sum(int[] arr) {
		long res = 0;
		for (int i = 0; i < arr.length; i++) {
			res += arr[i];
		}
		return res;
	}

	public void que(Queue<Integer> q, int[] a) {
		for (int i = 0; i < a.length; i++) {
			q.add(a[i]);
		}
	}
}
