import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, ans, max;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;
			max = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(map[i][j], max);
				}
			}

			for (int i = 0; i <= max; i++) {
				solution(i);
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void solution(int count) {

		int temp_ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == count) {
					visited[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					temp_ans++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) { // 다시 초기화
			for (int j = 0; j < N; j++) {
				for (int k = 1; k <= count; k++) {
					if (map[i][j] == k) {
						visited[i][j] = true;
					}
				}
			}
		}

		ans = Math.max(temp_ans, ans);
	}

	// TODO: count = 1 해두고 count 를 증가시키면서 visited 를 true로 한다.
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

}
