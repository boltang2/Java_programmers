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

// ���� ������ �𸣰� int�� �����ߴٰ� �ð� ������ ���ȴ�... ���� ���� �ߺ���