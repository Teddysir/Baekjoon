import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, size;
	static char[][] map;
	static boolean[][] visited;
	static int[][] bomb;

	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, 1, -1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			size = Integer.parseInt(br.readLine());
			map = new char[size][size];
			visited = new boolean[size][size];
			ans = 0;

			for (int i = 0; i < size; i++) {
				String input = br.readLine();
				for (int j = 0; j < size; j++) {
					map[i][j] = input.charAt(j);
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (map[i][j] != '*') {
						findBomb(i, j);
					}
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (map[i][j] == '0' && !visited[i][j]) {
						bfs(i, j); // 0인 애들 먼저 찾자
						ans++;
					}
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (map[i][j] != '*' && !visited[i][j]) { // 만약 지뢰좌표 아니고 숫자좌표인데 아직 방문 안했으면 하나씩 클릭해야하니까 ans ++;
						ans++;
					}
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void findBomb(int r, int c) {
		int tempB = 0;

		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < size && nc < size) {
				if (map[nr][nc] == '*') {
					tempB++;
				}
			}
		}
		map[r][c] = (char) (tempB + '0'); // 일단 좌표초기화 해주고
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < size && nc < size && !visited[nr][nc]) {
					if (map[nr][nc] == '0') {
						q.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					} else {
						visited[nr][nc] = true;
					}
				}
			}

		}

	}

}
