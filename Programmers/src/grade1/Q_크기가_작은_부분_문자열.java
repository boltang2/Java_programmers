package grade1;
import java.util.Stack;
class Solution {
	public int solution(String t, String p) {
		int answer = 0;
        int leng = p.length();
        long pp = Long.parseLong(p);
        
        for(int i = 0; i < t.length() - (leng - 1); i++ ){
            if(Long.parseLong(t.substring(i, i + leng)) <= pp){
                answer++;
            }
        }
    
		return answer;
	}
}

// 출제 범위를 모르고 int로 선언했다가 시간 개같이 날렸다... 숫자 범위 잘보자