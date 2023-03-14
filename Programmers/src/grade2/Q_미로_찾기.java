import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

class Solution {
	int col;
	int row;
	String[][] map;
	int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int solution(String[] maps) {
		int answer = 0;
		col = maps.length;
		row = maps[0].length();
		map = new String[col][row];
		int[] start = null;
		int[] lever = null;
		int[] exit = null;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				String factor = String.valueOf(maps[i].charAt(j));
				map[i][j] = factor;
				switch (factor) {
				case "S":
					start = new int[] { i, j };
					break;
				case "L":
					lever = new int[] { i, j };
					break;
				case "E":
					exit = new int[] { i, j };
					break;
				default:
					break;
				}
			}
		}
		int[][] sum = new int[][] { start, lever, exit };
		for (int i = 0; i < 2; i++) {
			int s = bfs(sum[i], sum[i + 1]);
			if (s < 0) {
				return -1;
			} else {
				answer += s;
			}
		}
		return answer;
	}

	public int bfs(int[] start, int[] end) {
		boolean[][] visited = new boolean[col][row];
		visited[start[0]][start[1]] = true;
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { start[0], start[1], 0 });
		while (!que.isEmpty()) {
			int[] search = que.poll();
			if (search[0] == end[0] && search[1] == end[1]) {
				return search[2];
			}
			for (int i = 0; i < 4; i++) {
				int[] next = new int[3];
				next[0] = search[0] + dir[i][0];
				next[1] = search[1] + dir[i][1];
				next[2] = search[2] + 1;
				if (next[0] < 0 || next[0] == col || next[1] < 0 || next[1] == row) {
					continue;
				}
				if (!visited[next[0]][next[1]] && !map[next[0]][next[1]].equals("X")) {
					visited[next[0]][next[1]] = true;
					que.add(next);
				}
			}
		}
		return -1;
	}
}
