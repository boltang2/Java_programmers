import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public int solution(int[] order) {
		int answer = 0;
		Stack<Integer> con = new Stack<Integer>();
		for (int i = order.length; i >= 1; i--) {
			con.push(i);
		}
		Stack<Integer> sub = new Stack<Integer>();
		for (int i = 0; i < order.length; i++) {
			if (!container(con, sub, order[i])) {
				break;
			}
			answer++;
		}
		return answer;
	}

	public boolean container(Stack<Integer> stk, Stack<Integer> que, int n) {
		System.out.println("stk = " + stk + "sub = " + que);
		int con = n + 1;
		int sub = 0;
		if (!stk.isEmpty()) {
			con = stk.peek();
		}
		if (!que.isEmpty()) {
			sub = que.peek();
		}
		if (n > con) {
			while (n > con) {
				que.add(stk.pop());
				con = stk.peek();
			}
			stk.pop();
			System.out.printf("n = %d con = %d sub = %d \n", n, con, sub);
			System.out.println("stk = " + stk + "sub = " + que);
			return true;
		} else if (n == con) {
			System.out.println("stk");
			stk.pop();
			return true;
		} else if (n == sub) {
			System.out.println("sub");
			que.pop();
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
}