class Solution {
    public int solution(int a, int b, int n) {
    	// a �ݳ��ϴ� �� b a���� �ݳ��ϸ� �ִ� ���� b n ������ �ִ� �� ����
        int answer = 0;
        while(a <= n) {
        	answer += (n / a) * b;
        	n = (n / a) * b + n % a;
        }
        return answer;
    }
}
