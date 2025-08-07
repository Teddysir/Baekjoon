import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, TC, ans;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {
			ans = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					visited = new boolean[N][N];
					ans = Math.max(ans, bfs(i, j));
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;
		int tempAns = map[x][y];
		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];

				if (nx >= x && ny >= y && nx < x + M  && ny < y + M  && !visited[nx][ny]) {
					tempAns += map[nx][ny];
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}

		return tempAns;
	}

}
