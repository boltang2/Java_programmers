class Solution {
    public int solution(String s) {
    	String[][] chart = {{"zero","0"},
    						{"one","1"},
       						{"two","2"},
       						{"three","3"},
       						{"four","4"},
       						{"five","5"},
       						{"six","6"},
       						{"seven","7"},
       						{"eight","8"},
       						{"nine","9"},};
    	for(String[] tmp : chart) {
    		s = s.replace(tmp[0], tmp[1]);
    	}
        int answer = Integer.parseInt(s);
        return answer;
    }
}