import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N, K;
	static int[] volumes, values;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			volumes = new int[N + 1];
			values = new int[N + 1];
			dp = new int[K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				volumes[i] = Integer.parseInt(st.nextToken());
				values[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				for (int j = K; j >= volumes[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - volumes[i]] + values[i]);
				}
			}

			sb.append("#").append(k).append(" ").append(dp[K]).append("\n");

		}
		System.out.println(sb);
	}

}
