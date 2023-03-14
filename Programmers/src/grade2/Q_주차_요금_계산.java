import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		HashMap<String, int[]> maps = new HashMap<String, int[]>();
		for (int i = 0; i < records.length; i++) {
			String[] tmp = records[i].split(" ");
			String time = tmp[0];
			String name = tmp[1];
			String stat = tmp[2];
			if (stat.equals("IN")) {
				maps.put(name, new int[] { minute(time), maps.getOrDefault(name, new int[2])[1], 0 });
			} else {
				maps.put(name, new int[] { minute(time), maps.get(name)[1] + minute(time) - maps.get(name)[0], 1 });
			}
		}

		for (String key : maps.keySet()) {
			int[] tmp = maps.get(key);
			if (tmp[2] == 0) {
				maps.put(key, new int[] { minute("23:59"), maps.get(key)[1] + minute("23:59") - maps.get(key)[0], 1 });
			}
			System.out.print(key + " : ");
			System.out.println(Arrays.toString(maps.get(key)));
		}
		return answer;
	}

	public int minute(String t) {
		int hour = Integer.parseInt(t.split(":")[0]);
		int min = Integer.parseInt(t.split(":")[1]);
		return (hour * 60 + min);
	}
}
