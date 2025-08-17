import java.io.*;
import java.util.*;

public class Main {

	static int R, C, ans;
	static char[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 0, 1 }; // 위, 가운데, 아래
	static int[] dc = { 1, 1, 1 }; // 앞 앞 앞

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		ans = 0;
		for (int i = 0; i < R; i++) {
			solution(i, 0);
		}
		System.out.println(ans);

	}

	// dfs 그래프 탐색 + 조합?
	static boolean solution(int r, int c) {

		visited[r][c] = true;

		if (c == C - 1) { // 기저조건 안넣어도되려나
			ans++;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= R || nc >= C || visited[nr][nc] || map[nr][nc] == 'x') {
				continue;
			} else {
				visited[nr][nc] = true;
				if (solution(nr, nc)) {
					return true;
				}

			}
		}
		return false;

	}
}
