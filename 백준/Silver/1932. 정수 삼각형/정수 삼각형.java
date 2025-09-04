
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] tri;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		tri = new int[N + 2][N + 2];
		dp = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
//		dp[1][1] = tri[1][1];

		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dp[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + tri[i][j];
					dp[i][j + 1] = dp[i - 1][j] + tri[i][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + tri[i][j]);
					dp[i][j + 1] = dp[i - 1][j] + tri[i][j + 1];
				}

				if (dp[i][j] > max)
					max = dp[i][j];
			}

		}

		System.out.println(max);
	}

}
