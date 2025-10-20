import java.io.*;
import java.util.*;

public class Main {

	static int INF = 1_000_000_000;
	static int N;
	static int[][] W;
	static int[][] dp; // 1차원은 출발점, 2차원은 방문 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		W = new int[N][N];
		dp = new int[N][(1 << N)];

//		System.out.println(Arrays.toString(dp[1]));

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1); // 최대로~
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 1));

	}

	static int dfs(int now, int visit) {

		if (visit == (1 << N) - 1) { // 모든걸 방문했다면?
			if (W[now][0] == 0) {
				return INF; // 만약 근데 돌아가는 길 없다면 무한,
			}
			return W[now][0]; // 아니라면,
		}

		if (dp[now][visit] != -1) // 방문한적이 있다면?
			return dp[now][visit];
		dp[now][visit] = INF;

		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) == 0 && W[now][i] != 0) {
				dp[now][visit] = Math.min(dp[now][visit], dfs(i, visit | (1 << i)) + W[now][i]);
			}
		}

		return dp[now][visit];
	}

}
