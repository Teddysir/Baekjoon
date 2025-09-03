import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int N, L;

	static int[][] dp;

	static int[] tastes;
	static int[] calories;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			dp = new int[N + 1][L + 1];
			tastes = new int[N+1];
			calories = new int[N+1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				tastes[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			solution();

			sb.append("#").append(k).append(" ").append(dp[N][L]).append("\n");

		}
		System.out.println(sb);
	}

	static void solution() {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= L; j++) {
				dp[i][j] = j >= calories[i] ? Math.max(dp[i-1][j], dp[i-1][j-calories[i]] + tastes[i]) : dp[i-1][j];
			}
		}

	}

}
