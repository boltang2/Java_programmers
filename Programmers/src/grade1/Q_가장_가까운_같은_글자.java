import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
        	String tmp = String.valueOf(s.charAt(i));
        	if(!map.containsKey(tmp)) {
        		answer[i] = -1;
        	} else {
        		answer[i] = i - map.get(tmp);
        	}
        	map.put(tmp,i);
        }
        return answer;
    }
}
