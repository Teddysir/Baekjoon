import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int[] fees;
	static int[] dp;
	static int[] month;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			fees = new int[4];
			for (int i = 0; i < 4; i++) {
				fees[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[13];
			month = new int[13];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= 12; i++) {
				dp[i] = Math.min(dp[i - 1] + month[i] * fees[0], dp[i - 1] + fees[1]);

				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + fees[2]);
				}
			}

			sb.append("#").append(k).append(" ").append(Math.min(dp[12], fees[3])).append("\n");

		}
		System.out.println(sb);
	}

}
