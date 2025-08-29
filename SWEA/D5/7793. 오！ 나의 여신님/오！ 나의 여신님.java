import java.io.*;
import java.util.*;

public class Solution {

	static int TC, R, C, ans;
	static char[][] map;

	static int[][] death_map;
	static int[][] play_map;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int endR;
	static int endC;

	static class Node {
		int r, c, weigth;

		Node(int r, int c, int weigth) {
			this.r = r;
			this.c = c;
			this.weigth = weigth;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];

			// 악마의 손아귀? 퍼지는 영역 배열 선언
			death_map = new int[R][C];
			// 게임맵
			play_map = new int[R][C];

			// 내위치는S, 여신의 공간은 D, 돌 X, 악마 *, . 길.

			int startR = 0;
			int startC = 0;

			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'S') {
						startR = i;
						startC = j;
					}
					if (map[i][j] == '.') {
						death_map[i][j] = Integer.MAX_VALUE;
						play_map[i][j] = Integer.MAX_VALUE;
					}
					if (map[i][j] == 'D') {
						play_map[i][j] = Integer.MAX_VALUE;
						death_map[i][j] = Integer.MAX_VALUE;
						endR = i;
						endC = j;
					}

				}
			}

			/// 악마의손길 최소거리 구하기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*') {
						make_death_map(i, j);
					}
				}
			}


			ans = Integer.MAX_VALUE;
			solution(startR, startC);

			if (ans == Integer.MAX_VALUE) {
				sb.append("#").append(k).append(" ").append("GAME OVER").append("\n");
			} else {
				sb.append("#").append(k).append(" ").append(ans).append("\n");
			}

		}
		System.out.println(sb);
	}

	static void solution(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];

				if (nr == endR && nc == endC) {
					ans = Math.min(ans, play_map[temp[0]][temp[1]] + 1); // < 수정
					return;
				}
				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					if (play_map[nr][nc] > play_map[temp[0]][temp[1]] + 1) { // 다음기존값이 내가가려는 값보다 큰데
						if (play_map[temp[0]][temp[1]] + 1 < death_map[nr][nc]) { // 내가 가려는 값이 죽ㅇ음손아귀 최소값보다 작으면
							play_map[nr][nc] = play_map[temp[0]][temp[1]] + 1;
							q.add(new int[] { nr, nc });
						}
					}
				}

			}
		}
	}

	static void make_death_map(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					if (map[nr][nc] == '.') {
						if (death_map[nr][nc] > death_map[temp[0]][temp[1]] + 1) {
							death_map[nr][nc] = death_map[temp[0]][temp[1]] + 1;
							q.add(new int[] { nr, nc }); //
						}
					}
				}
			}
		}
	}

}
