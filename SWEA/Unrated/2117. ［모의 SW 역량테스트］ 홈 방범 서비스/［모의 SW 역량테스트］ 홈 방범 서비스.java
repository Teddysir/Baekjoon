import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, M, ans;
	static int[][] map;
	static boolean[][] visited;

	static int total_house_fee, total_house;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 하나의 집 비용

			ans = Integer.MIN_VALUE;

			map = new int[N][N];
			total_house_fee = 0;
			total_house = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						total_house++;
					}
				}
			}
			total_house_fee = total_house * M;

			int cur_fee = 1;
			int range = 0;
			while (cur_fee <= total_house_fee) {
				cur_fee += (range * 4);
				range++;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						visited = new boolean[N][N];
						dist(i, j, range);
						int temp_fee = 0;

						for (int r = 0; r < N; r++) {
							for (int c = 0; c < N; c++) {
								if (visited[r][c] == true && map[r][c] == 1) {
									temp_fee += M;
								}
							}
						}

						if (temp_fee >= cur_fee) {
//							System.out.println(range);
							ans = Math.max(temp_fee / M, ans);
						}

					}
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static void dist(int r, int c, int range) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int dist = Math.abs(i - r) + Math.abs(j - c);

				if (dist < range) {
					visited[i][j] = true;
				}
			}
		}
	}
}
