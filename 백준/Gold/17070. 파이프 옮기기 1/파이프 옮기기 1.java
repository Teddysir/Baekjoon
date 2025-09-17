import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int ans;

	static int[] dr = { 0, 1, 1 }; // 우, 대각, 아래
	static int[] dc = { 1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 0);
		// 0 우, 1 대각, 2 아래

		System.out.println(ans);

	}

	static void dfs(int r, int c, int dir) {

		if (dir == 0) { // 현재 방향이 우
			for (int i = 0; i < 2; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				checker(nr, nc, i); // 다음 좌표와 방향
			}
		} else if (dir == 1) { // 현재 방향이 대각
			for (int i = 0; i < 3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				checker(nr, nc, i); // 다음 좌표와 방향
			}
		} else { // 현재 방향이 아래
			for (int i = 1; i < 3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				checker(nr, nc, i); // 다음 좌표와 방향
			}
		}

	}

	static void checker(int nr, int nc, int dir) {

		if (nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == 1)
			return;

		if (dir == 1) {
			if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) { // 대각으로 왔는데 위아래 0이여야하는데 1이 잇으면 못감 패스.
				return;
			}
		}

		if (nr == N && nc == N) { // 도착하면끝
			ans++;
			return;
		}

		if (nr >= 1 && nc >= 1 && nr <= N && nc <= N && map[nr][nc] != 1) {
			dfs(nr, nc, dir);
		}
	}

}