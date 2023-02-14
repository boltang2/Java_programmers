class Solution {
    public int solution(int a, int b, int n) {
    	// a 반납하는 병 b a병을 반납하면 주는 갯수 b n 가지고 있는 빈병 갯수
        int answer = 0;
        while(a <= n) {
        	answer += (n / a) * b;
        	n = (n / a) * b + n % a;
        }
        return answer;
    }
}
