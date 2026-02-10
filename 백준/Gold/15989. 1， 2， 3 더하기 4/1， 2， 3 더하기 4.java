import java.io.*;
import java.util.*;

public class Main {

	static int T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dpCal(input)).append("\n");
		}
		System.out.println(sb);

	}

	static int dpCal(int targetNum) {
		int[] dp = new int[10001];
		dp[0] = 1;

		for (int i = 1; i <= 10000; i++) {
			dp[i] += dp[i - 1];
		}

		for (int i = 2; i <= 10000; i++) {
			dp[i] = dp[i] + dp[i - 2];
		}

		for (int i = 3; i <= 10000; i++) {
			dp[i] = dp[i] + dp[i - 3];
		}

		return dp[targetNum];
	}

}
