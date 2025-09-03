import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int[] weight;
	static int[] values;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N + 1];
		values = new int[N + 1];
		dp = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());

		}
		for (int i = 1; i <= N; i++) {
			for (int j = K; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
			}
		}

		System.out.println(dp[K]);

	}

}
