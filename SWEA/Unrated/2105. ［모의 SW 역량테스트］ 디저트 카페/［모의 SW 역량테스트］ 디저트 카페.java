import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N, dessert_max;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] dessert;
	static int drift;

	static int re_x, re_y, count;

	static int[] dr = { 1, 1, -1, -1 }; // 5시, 7시, 11시, 1시 // 어짜피 한 방향으로 돈다고 생각해보자 추가,
	static int[] dc = { 1, -1, -1, 1 };
	/// 직진을 하거나, 방향을 꺾거나 ,
	/// 방향은 총 3번밖에 못꺾고 -> 만약 3번을 꺾었다면 직진만 가능하고,
	/// 직진을하다가 시작좌표가 존재하면 O 만약 없다면 -1 ?

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			// 맵 사이즈
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			// 맵 좌표를 입력받는다.
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > dessert_max) {
						dessert_max = map[i][j]; // 최대 디저트 값 초기화
					}
				}
			}
			// 방문 디저트 배열 선언

			ans = -1; // -1로 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N]; // 방문배열 초기화
					dessert = new boolean[dessert_max + 1]; // 방문한 디저트 가지수 저장 배열
					count = 1; // 몇번 움직였는가? // 시작지점 포함 
					re_x = i;
					re_y = j;
					solution(i, j);
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void solution(int r, int c) {

		dessert[map[r][c]] = true; // 먹고시작하고
//		for (int i = 0; i < 4; i++) {
		drift = 0; // 최대 3까지 가능
		dfs(r, c, 0);
//		}
	}

	static void dfs(int r, int c, int dir) {

		int nr = r + dr[dir]; // 일단 들어온 방향으로 가고
		int nc = c + dc[dir];

		if (nr == re_x && nc == re_y && drift == 3) { // 만약 들어온 좌표가 원위치고 3번 꺾었다.
			ans = Math.max(ans, count); // 정답
			return;
		}

		if (nr >= 0 && nc >= 0 && nr < N && nc < N) { // 만약 다음으로직진해서 갈 수있다면
			if (!dessert[map[nr][nc]]) {
				visited[nr][nc] = true;
				count++;
				dessert[map[nr][nc]] = true;
				dfs(nr, nc, dir); // 그방향 그대로 가면되고

				if (drift < 3 && dir < 3) {
					drift++;
					dfs(nr, nc, dir + 1);
					drift--;
				}

				visited[nr][nc] = false;
				count--;
				dessert[map[nr][nc]] = false;
			}

		}

	}

}
