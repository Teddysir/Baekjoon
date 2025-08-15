
import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, max_height;
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
//	static boolean k_count;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 깎을 수 있는 높이 // 가능한 높이
			map = new int[N][N];

			max_height = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max_height) {
						max_height = map[i][j]; // 최대높이 봉우리 갱신
					}
				}
			}

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max_height) {
						boolean k_count = false;
						visited = new boolean[N][N];
						solution(i, j, k_count, 1);
					}
				}
			}
//			System.out.println(Arrays.deepToString(visited));

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void solution(int row, int col, boolean k_count, int temp_ans) {

		if (temp_ans > ans) {
			ans = temp_ans;
		}

		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			// 갈 수 있는상태임 -> 벽이 아니라는 뜻

			// 그럼 그 다음에 선택을 해야함, 해당 벽을 부수고 갈지 안부수고 갈지,

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;

			if (map[row][col] > map[nr][nc]) {
				solution(nr, nc, k_count, temp_ans + 1);
			} else if (!k_count && map[row][col] <= map[nr][nc]) { // 만약 공사도 할 수있는데 다음 좌표가 더 크거나 같아
				if (map[row][col] > map[nr][nc] - K) {
					int temp = map[nr][nc];
					map[nr][nc] = map[row][col] - 1;
					solution(nr, nc, true, temp_ans + 1);
					map[nr][nc] = temp; // 복구
				}
			}
		}
		visited[row][col] = false;

	}

}
