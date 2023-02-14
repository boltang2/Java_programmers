import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
	public String solution(String X, String Y) {
		String answer = "";
		Map<String, Integer> mapX = new HashMap<String, Integer>();
		Map<String, Integer> mapY = new HashMap<String, Integer>();
		List<String> list = new ArrayList<>();
		
		for (String key : X.split("")) {
			mapX.put(key, mapX.getOrDefault(key, 0) + 1);
		}

		for (String key : Y.split("")) {
			mapY.put(key, mapY.getOrDefault(key, 0) + 1);
		}

		for (String key : mapX.keySet()) {
			if(!mapY.containsKey(key)) continue;
			
			int lenth = Math.min(mapX.get(key), mapY.get(key));
			
			for(int i = 0; i < lenth; i++) {
				list.add(key);
			}
			
//			for(int i = 0; i < lenth; i++) {
//				answer = key + answer;
//			}
		}
		
		answer = list.stream()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.joining());
		
		if(answer.isEmpty()) return "-1";
		else if(answer.replaceAll("0", "").isEmpty()) return "0";
		else return answer;
	}
}
