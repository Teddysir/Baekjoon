import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, ans;
	static int[][] map;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						map[i][j] = 100_100_100;
					}
				}
			}

			for (int k = 0; k < N; k++) {

				for (int i = 0; i < N; i++) {

					for (int j = 0; j < N; j++) {

						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);

					}
				}
			}

			for (int i = 0; i < N; i++) {
				int temp_result = 0;
				for (int j = 0; j < N; j++) {
					if (i != j) {
						temp_result += map[i][j];
					}
				}
				ans = Math.min(ans, temp_result);
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

}
