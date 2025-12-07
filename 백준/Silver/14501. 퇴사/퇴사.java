import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] times;
	static int[] costs;
	static int[] dp;
	static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		times = new int[N + 1];
		costs = new int[N + 1];
		dp = new int[N + 2];
//		Arrays.fill(dp, Integer.MIN_VALUE);

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			costs[i] = Integer.parseInt(st.nextToken());
		}
//		dp[1] = costs[1];

		for (int i = 1; i <= N; i++) {

			dp[i] = Math.max(dp[i], dp[i - 1]);

			int nextDate = i + times[i];

			if (nextDate <= N + 1) {
				dp[nextDate] = Math.max(dp[nextDate], dp[i] + costs[i]);
			}
		}

		int ans = -1;
		for (int i = 1; i <= N + 1; i++) {
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}

		System.out.println(ans);

	}

}
