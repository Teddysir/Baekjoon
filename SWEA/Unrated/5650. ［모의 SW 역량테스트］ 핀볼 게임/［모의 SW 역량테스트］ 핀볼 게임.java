import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, ans;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int start_r;
	static int start_c;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine().trim());
		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine().trim());
			ans = 0;
			map = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				map[i][N + 1] = map[N + 1][i] = map[0][i] = map[i][0] = 5;
			}

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							start_r = i;
							start_c = j;
							game(i, j, d);
						}
					}
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void game(int r, int c, int dir) {
	    int nr = r;
	    int nc = c;
	    int d = dir;
	    int score = 0;

	    while (true) {
	        nr += dr[d];
	        nc += dc[d];

	        if (nr == r && nc == c || map[nr][nc] == -1) break;

	        if (map[nr][nc] == 0) continue;

	        if (map[nr][nc] >= 1 && map[nr][nc] <= 5) {
	            d = drift(d, nr, nc);
	            score++;
	        } else if (map[nr][nc] >= 6 && map[nr][nc] <= 10) {
	            int[] next = warp(nr, nc);
	            nr = next[0];
	            nc = next[1];
	        }
	    }

	    ans = Math.max(ans, score);
	}

	static int[] warp(int nr, int nc) {

		int find_pos = map[nr][nc];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if ((map[i][j] == find_pos) && (nr != i || nc != j)) {
					int[] next_pos = new int[] { i, j };
					return next_pos;
				}
			}
		}
		return null;
	}

	static int drift(int cur_dir, int nr, int nc) { // 어디서 들어왔는가 ?

		if (cur_dir == 0) { // 만약 위로 올라가다가
			if (map[nr][nc] == 1) { // 1번을 만나면
				return 1; // 1이 밑으로 내려가라.
			} else if (map[nr][nc] == 2) {
				return 3;
			} else if (map[nr][nc] == 3) {
				return 2;
			} else if (map[nr][nc] == 4) {
				return 1;
			} else if (map[nr][nc] == 5) {
				return 1;
			}
		} else if (cur_dir == 1) {
			if (map[nr][nc] == 1) {
				return 3;
			} else if (map[nr][nc] == 2) {
				return 0;
			} else if (map[nr][nc] == 3) {
				return 0;
			} else if (map[nr][nc] == 4) {
				return 2;
			} else if (map[nr][nc] == 5) {
				return 0;
			}
		} else if (cur_dir == 2) {
			if (map[nr][nc] == 1) {
				return 0;
			} else if (map[nr][nc] == 2) {
				return 1;
			} else if (map[nr][nc] == 3) {
				return 3;
			} else if (map[nr][nc] == 4) {
				return 3;
			} else if (map[nr][nc] == 5) {
				return 3;
			}
		} else if (cur_dir == 3) {
			if (map[nr][nc] == 1) {
				return 2;
			} else if (map[nr][nc] == 2) {
				return 2;
			} else if (map[nr][nc] == 3) {
				return 1;
			} else if (map[nr][nc] == 4) {
				return 0;
			} else if (map[nr][nc] == 5) {
				return 2;
			}
		}
		return 10;
	}

}
