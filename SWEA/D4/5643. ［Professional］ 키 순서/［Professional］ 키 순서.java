import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, M, ans;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine()); // 학생 수
			M = Integer.parseInt(br.readLine()); // 비교 횟수

			arr = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a][b] = 1;
			}
			ans = 0;

			for (int i = 1; i <= N; i++) {
				boolean flag = false; // 각각 하나씩 flag세워서 가능한애들 체크
				visited = new boolean[N + 1];
				small(i);
				big(i);
				for (int j = 1; j <= N; j++) {
					if (!visited[j])
						flag = true;
				}
				if (!flag) {
					ans++;
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static void small(int start) {
		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (arr[i][start] == 1 && !visited[i]) {
				visited[i] = true;
				small(i);
			}
		}

	}

	static void big(int start) {
		for (int i = 1; i <= N; i++) {
			if (arr[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				big(i);
			}
		}
	}

}