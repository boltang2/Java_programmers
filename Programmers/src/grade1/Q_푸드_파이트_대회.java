class Solution {
    public String solution(int[] food) {
    	// food = [¹°, 1À½½Ä °¹¼ö, 2À½½Ä °¹¼ö, 3À½½Ä °¹¼ö]
    	String answer = "";

    	for(int i = 0; i < food.length; i++) {
    		if(food[i] < 2) {
    			food[i] = 0;
    		} else {
    			if(food[i] % 2 != 0) {
    				food[i]--;
    			}
    		}
    	}
    	for(int tmp : food) {
    		System.out.println(tmp + " ");
    	}
    	
    	for(int i = 1; i < food.length; i++) {
    		for(int j = 0; j < food[i] / 2; j++) {
    			answer = answer.concat(Integer.toString(i));
    		}
    	}
    	System.out.println(answer);
    	StringBuffer sb = new StringBuffer(answer);
    	String revAnswer = sb.reverse().toString();
    	
    	answer = answer.concat("0").concat(revAnswer);
        
        return answer;
    }
}
