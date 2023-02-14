import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int[] solution(String[] maps) {
		char[][] map = new char[maps.length][];
		boolean[][] visit = new boolean[maps.length][maps[0].length()];
		for (int i = 0; i < maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}
		ArrayList<Integer> islands = new ArrayList<>();

		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				int survive = makeIslands(col, row, map, visit);
				if (survive > 0)
					islands.add(survive);
			}
		}
		System.out.println(islands);
		if (islands.isEmpty()) {
			return new int[] { -1 };
		} else {
			Collections.sort(islands);
			return islands.stream().mapToInt(i -> i).toArray();
		}

	}

	public int makeIslands(int col, int row, char[][] map, boolean[][] visit) {
		if (col < 0 || row < 0 || col == map.length || row == map[0].length) {
			return 0;
		}
		if (visit[col][row] || map[col][row] == 'X') {
			return 0;
		}

		int survive = map[col][row] - '0';
		visit[col][row] = true;

		survive += makeIslands(col - 1, row, map, visit);
		survive += makeIslands(col + 1, row, map, visit);
		survive += makeIslands(col, row - 1, map, visit);
		survive += makeIslands(col, row + 1, map, visit);

		return survive;
	}
}