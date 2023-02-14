import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(id_list));
		HashMap<String, HashSet<String>> mapReportInfo = new HashMap<>();
		/*
		 * mapReportInfo (key : �Ű���, value : key�� �Ű��ѻ��) 
		 * A : B C D 
		 * B : C 
		 * C : A 
		 * ....
		 */
		HashMap<String, Integer> mapReportedCount = new HashMap<>();
		/*
		 * mapReportedCount(key : �Ű���ѻ��, value : �Ű���� Ƚ��) 
		 * A : 3 
		 * B : 2 
		 * ...
		 */
		for (String rep : report) {
			String reporter = rep.split(" ")[0];
			String reported = rep.split(" ")[1];
			mapReportInfo.putIfAbsent(reporter, new HashSet<String>());
			mapReportInfo.get(reporter).add(reported);
		}
		for (String mapReporter : mapReportInfo.keySet()) {
			for (String mapReported : mapReportInfo.get(mapReporter)) {
				mapReportedCount.put(mapReported, mapReportedCount.getOrDefault(mapReported, 0) + 1);
			}
		}
		for (String info : mapReportInfo.keySet()) {
			System.out.print(info + " : ");
			for (String in : mapReportInfo.get(info)) {
				System.out.print(in + " ");
			}
			System.out.println();
		}
		for (String info : mapReportedCount.keySet()) {
			System.out.printf("%s : %d\n", info, mapReportedCount.get(info));
		}

		for (int i = 0; i < list.size(); i++) {
			if (mapReportInfo.get(list.get(i)) != null) {
				for (String isPunish : mapReportInfo.get(list.get(i))) {
					if (mapReportedCount.get(isPunish) >= k) {
						answer[i]++;
					}
				}
			}
		}
		return answer;
	}
}