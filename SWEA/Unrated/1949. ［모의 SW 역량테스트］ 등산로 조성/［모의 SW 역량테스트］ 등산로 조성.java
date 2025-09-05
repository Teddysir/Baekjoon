import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int start;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 1;

			map = new int[N][N];
			start = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > start) {
						start = map[i][j];
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == start) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						dfs(i, j, false, 1);

					}
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void dfs(int r, int c, boolean broken, int count) {

		if (ans < count) {
			ans = count;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {

				if (map[nr][nc] < map[r][c] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, broken, count + 1);
				} else if (map[nr][nc] >= map[r][c]) {
					if (!broken && map[nr][nc] - K < map[r][c] && !visited[nr][nc]) { // 만약 부순적이 없다면,
						int temp = map[nr][nc];
						map[nr][nc] = map[r][c] - 1;
						broken = true;
						visited[nr][nc] = true;
						dfs(nr, nc, broken, count + 1);
						broken = false;
						map[nr][nc] = temp;
					}
				}
				visited[nr][nc] = false;
			}

		}

//		}

	}

}
