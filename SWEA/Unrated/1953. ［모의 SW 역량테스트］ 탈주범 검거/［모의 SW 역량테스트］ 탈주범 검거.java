import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int R, C;
	static int startR, startC, time;

	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;

	static int[] dr = { 1, -1, 0, 0 };// 아래, 위, 오른쪽 왼
	static int[] dc = { 0, 0, 1, -1 }; // 0 1 2 3

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken()); // 시작 위치
			startC = Integer.parseInt(st.nextToken()); // 시작 위치
			time = Integer.parseInt(st.nextToken());

			map = new int[R][C];
			dist = new int[R][C];
			visited = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			ans = 0;

			int num = map[startR][startC];

			List<Integer> go = checker(num);

			dist[startR][startC] = 1;
			visited[startR][startC] = true;

			for (int i = 0; i < go.size(); i++) {
				dfs(1, go.get(i), startR, startC);
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (dist[i][j] > 0 && visited[i][j]) {
						ans++;
					}
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void dfs(int depth, int dir, int r, int c) {

		if (depth == time) {
			return;
		}

		if (dir == 0) {
			if (r + 1 < R) {
				if (map[r + 1][c] == 1 || map[r + 1][c] == 2 || map[r + 1][c] == 4 || map[r + 1][c] == 7) {
					if (dist[r + 1][c] > dist[r][c] + 1) {
						dist[r + 1][c] = dist[r][c] + 1;
						visited[r + 1][c] = true;
						List<Integer> go = checker(map[r + 1][c]);
						for (int i = 0; i < go.size(); i++) {
							dfs(depth + 1, go.get(i), r + 1, c);
						}
					}
				}
			}
		} else if (dir == 1) {
			if (r - 1 >= 0) {
				if (map[r - 1][c] == 1 || map[r - 1][c] == 2 || map[r - 1][c] == 5 || map[r - 1][c] == 6) {
					if (dist[r - 1][c] > dist[r][c] + 1) {
						dist[r - 1][c] = dist[r][c] + 1;
						visited[r - 1][c] = true;
						List<Integer> go = checker(map[r - 1][c]);
						for (int i = 0; i < go.size(); i++) {
							dfs(depth + 1, go.get(i), r - 1, c);
						}
					}
				}
			}
		} else if (dir == 2) {
			if (c + 1 < C) {
				if (map[r][c + 1] == 1 || map[r][c + 1] == 3 || map[r][c + 1] == 6 || map[r][c + 1] == 7) {
					if (dist[r][c + 1] > dist[r][c] + 1) {
						dist[r][c + 1] = dist[r][c] + 1;
						visited[r][c + 1] = true;
						List<Integer> go = checker(map[r][c + 1]);
						for (int i = 0; i < go.size(); i++) {
							dfs(depth + 1, go.get(i), r, c + 1);
						}
					}
				}
			}
		} else {
			if (c - 1 >= 0) {
				if (map[r][c - 1] == 1 || map[r][c - 1] == 3 || map[r][c - 1] == 4 || map[r][c - 1] == 5) {
					if (dist[r][c - 1] > dist[r][c] + 1) {
						dist[r][c - 1] = dist[r][c] + 1;
						visited[r][c - 1] = true;
						List<Integer> go = checker(map[r][c - 1]);
						for (int i = 0; i < go.size(); i++) {
							dfs(depth + 1, go.get(i), r, c - 1);
						}
					}
				}
			}
		}

	}

	static List<Integer> checker(int what) {

		List<Integer> go = new ArrayList<Integer>();

		if (what == 1) {
			go.add(0);
			go.add(1);
			go.add(2);
			go.add(3);
		} else if (what == 2) {
			go.add(0);
			go.add(1);
		} else if (what == 3) {
			go.add(2);
			go.add(3);
		} else if (what == 4) {
			go.add(1);
			go.add(2);
		} else if (what == 5) {
			go.add(0);
			go.add(2);
		} else if (what == 6) {
			go.add(0);
			go.add(3);
		} else {
			go.add(1);
			go.add(3);
		}
		return go;
	}

}
