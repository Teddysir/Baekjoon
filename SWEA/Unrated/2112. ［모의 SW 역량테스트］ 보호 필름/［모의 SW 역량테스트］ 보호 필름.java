import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, D, W, K;
	static int[][] film;
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = D; // 모든 열에 다 넣을때가 최대일듯?

			A = new int[W];
			B = new int[W];
			Arrays.fill(B, 1);

			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void dfs(int count, int depth) {
		if (check()) {
			if (count < ans) {
				ans = count;
				return;
			}
		}

		if (count > ans) {
			return;
		}

		if (depth == D) {
			return;
		}

		dfs(count, depth + 1);
		int[] remember = film[depth];

		film[depth] = A;
		dfs(count + 1, depth + 1);

		film[depth] = B;
		dfs(count + 1, depth + 1);

		film[depth] = remember;

	}

	static boolean check() {

		for (int i = 0; i < W; i++) {
			boolean flag = false;
			int check = 1;
			for (int j = 1; j < D; j++) {
				if (film[j][i] == film[j - 1][i]) {
					check++;
				} else {
					check = 1;
				}
				if (check == K) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}

		return true;
	}

}
