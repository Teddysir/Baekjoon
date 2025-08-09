import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, M, ans;
	static int[] arr;
	static boolean[][] checker;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			ans = 0;

			N = Integer.parseInt(st.nextToken()); // 3이면 1,2,3 재
			M = Integer.parseInt(st.nextToken()); // 안되는 재료 몇개 반환받을지

			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}

			checker = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				checker[a][b] = checker[b][a] = true;
			}

			solution(1, new boolean[N + 1]);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static void solution(int cnt, boolean[] isSelected) {

		if (cnt == N + 1) {
			ans++;
			return;
		}

		boolean keep = true;

		for (int i = 1; i <= cnt; i++) {
			if (checker[cnt][i] && isSelected[i]) {
				keep = false;
				break;
			}
		}
		if (keep) {
			isSelected[cnt] = true;
			solution(cnt + 1, isSelected);
			isSelected[cnt] = false;
		}
		solution(cnt + 1, isSelected);

	}

}
